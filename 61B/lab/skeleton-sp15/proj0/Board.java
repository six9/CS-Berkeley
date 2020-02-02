public class Board {
	private static int N = 8;
	private boolean shouldBeEmpty;
	private Piece[][] pieces = new Piece[N][N];
	private Piece selectedPiece;
	private boolean fireTurn = true;
	private boolean turned = false;
	private boolean moved = false;

	/* Starts a GUI supported version of the game */
	public static void main(String[] args) {
		StdDrawPlus.setXscale(0, N);
		StdDrawPlus.setYscale(0, N);
		Board b = new Board(false);
		b.drawBoard(N);
		b.updateBoard();

		while (b.winner() == null) {
			int x = 1;
			int y = 0;
			if (StdDrawPlus.mousePressed()) {
				x = (int) StdDrawPlus.mouseX();
				y = (int) StdDrawPlus.mouseY();
			}			
			StdDrawPlus.show(10);

			if (b.canSelect(x, y)) {
				b.drawBoard(N);
				b.select(x, y);
				b.updateBoard();
			}

			if (b.canEndTurn() && StdDrawPlus.isSpacePressed()) {
				b.endTurn();
				b.drawBoard(N);
				b.updateBoard();
			}
		}

		StdDrawPlus.show(10);
		b.drawBoard(N);
		b.updateBoard();
		System.out.println(b.winner() + " WINS!");
		return;
	}

	/* The constructor for Board. If shouldBeEmpty is true, initializes an empty Board.
	 * Otherwise, initializes a Board with the default configuration. Note that an empty
	 * Board could possibly be useful for testing purposes. */
	public Board(boolean shouldBeEmpty) {
		this.shouldBeEmpty = shouldBeEmpty;
		if (!shouldBeEmpty) {
			for (int i = 0; i < N; i += 2) {
				// fire pieces
				pieces[i][0] = new Piece(true, this, i, 0, "pawn");
				pieces[i + 1][1] = new Piece(true, this, i + 1, 1, "shield");
				pieces[i][2] = new Piece(true, this, i, 2, "bomb");
				// water pieces
				pieces[i + 1][7] = new Piece(false, this, i + 1, 7, "pawn");
				pieces[i][6] = new Piece(false, this, i, 6, "shield");
				pieces[i + 1][5] = new Piece(false, this, i + 1, 5, "bomb");				
			}
		}
	}

	/* Gets the piece at position (x, y) on the board, or null if there is no piece.
	 * If (x, y) are out of bounds, returns null. */
	public Piece pieceAt(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1) {
			return null;
		} else {
			return pieces[x][y];
		}
	}

	/* Returns true if the square at (x, y) can be selected. */
	public boolean canSelect(int x, int y) {
		Piece p = pieceAt(x, y);

		if (moved) {
			return false;
		}

		if (p != null) {
			// Squares with a piece
			if ((fireTurn && p.isFire()) || (!fireTurn && !p.isFire())) {
				return true;
				// if (selectedPiece == null) { // The player has not selected a piece yet.
				// 	return true;
				// } else if (selectedPiece == p) { // The player has selected a piece, but did not move it.
				// 	return true;					
				// }
			}
		} else {
			// Empty squares
			if (selectedPiece != null) {
				// Due to the stupid API of Piece, we have to find the selected piece.
				int i = 0;
				int j = 0;
				// http://stackoverflow.com/questions/886955/breaking-out-of-nested-loops-in-java
				outerLoop:
				for (i = 0; i < N; i++) {
					for (j = 0; j < N; j++) {
						if (pieceAt(i, j) == selectedPiece) {
							break outerLoop;
						}
					}
				}
				/* During this turn, the player has selected a Piece which hasn’t moved
				 * yet and is selecting an empty spot which is a valid move for the
				 * previously selected Piece. */
				if (selectedPiece == p && validMove(i, j, x, y, false)) {
					return true;
				}

				/* During this turn, the player has selected a Piece, captured, and has
				 * selected another valid capture destination. When performing
				 * multi-captures, you should only select the active piece once; all
				 * other selections should be valid destination points. */
				if (!selectedPiece.hasCaptured()) {
					return validMove(i, j, x, y, false);
				} else {
					return validMove(i, j, x, y, true);
				}
			} 
		}
		return false;
	}

	/* Returns true if the piece at (xi, yi) can either move to (xf, yf) or capture to
	 * (xf, yf), strictly from a geometry/piece-race point of view. */
	private boolean validMove(int xi, int yi, int xf, int yf, boolean multiCapture) {
		if (xi < 0 || xi > N - 1 || yi < 0 || yi > N - 1) {
			return false;
		}
		if (xf < 0 || xf > N - 1 || yf < 0 || yf > N - 1) {
			return false;
		}

		int dx = xf - xi;
		int dy = yf - yi;

		// Simple move
		if (!multiCapture) {
			if (pieceAt(xi, yi).isKing()) {
				if (dx * dx + dy * dy == 2) {
					return true;
				}
			} else {
				if (fireTurn && dx * dx == 1 && dy == 1) {
					return true;
				} else if (!fireTurn && dx * dx == 1 && dy == -1) {
					return true;
				}
			}			
		}

		// Capture
		int xm = (xi + xf) / 2;
		int ym = (yi + yf) / 2;
		if (pieceAt(xi, yi).isKing()) {
			if (dx * dx + dy * dy == 8) {
				if (fireTurn && !pieceAt(xm, ym).isFire()) { // Fire captures water.
					return true;
				} else if (!fireTurn && pieceAt(xm, ym).isFire()) { // Water captures fire.
					return true;
				}
			}
		} else {
			if (fireTurn && dx * dx == 4 && dy == 2 && !pieceAt(xm, ym).isFire()) {
				return true;
			} else if (!fireTurn && dx * dx == 4 && dy == -2 && pieceAt(xm, ym).isFire()) {
				return true;
			}
		}

		return false;
	}

	/* Selects the square at (x, y). */
	public void select(int x, int y) {
		if (pieceAt(x, y) != null) {
			selectedPiece = pieceAt(x, y);
			StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
			StdDrawPlus.filledSquare(x + .5, y + .5, .5);
		} else {
			if (selectedPiece != null) {
				selectedPiece.move(x, y);
				turned = true;
				if (!selectedPiece.hasCaptured()) {
					moved = true;
				} else if (selectedPiece.isBomb()) {
					explode(selectedPiece);
					moved = true;
				}
			}
		}
	}

	/* Remove pieces destroyed by the explosion. */
	private void explode(Piece p) {
		int i = 0;
		int j = 0;

		outerLoop:
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				if (pieceAt(i, j) == p) {
					break outerLoop;
				}
			}
		}

		for (int m = i - 1; m <= i + 1; m++) {
			for (int n = j - 1; n <= j + 1; n++) {
				if (pieceAt(m, n) != null && !pieceAt(m, n).isShield()) {
					remove(m, n);
				}
			}
		}
	}

	/* Places p at (x, y). */
	public void place(Piece p, int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || p == null) {
			return;
		} else {
			// Checking if p is already on the board.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (pieceAt(i, j) == p) {
						if (i == x && j == y) {
							turned = false;
							return;
						}
						pieces[i][j] = null;
					}
				}
			}
			pieces[x][y] = p;
		}
	}

	/* Executes a remove. */
	public Piece remove(int x, int y) {
		if (x < 0 || x > N - 1 || y < 0 || y > N - 1) {
			System.out.println("Out of bound!");
			return null;
		} 
		if (pieces[x][y] == null) {
			System.out.println("No piece here!");
			return null;
		}
		Piece pieceXY = pieceAt(x, y);
		pieces[x][y] = null;
		return pieceXY;
	}

	/* Returns whether or not the the current player can end their turn. */
	public boolean canEndTurn() {
		return turned;
	}

	/* Called at the end of each turn. */
	public void endTurn() {
		fireTurn = !fireTurn;
		turned = false;
		if (selectedPiece != null) {
			selectedPiece.doneCapturing();
		}
		selectedPiece = null;
		moved = false;
	}

	/* Returns the winner of the game: "Fire", "Water", "No one", or null. */
	public String winner() {
		boolean fireExist = false;
		boolean waterExist = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (pieceAt(i, j) != null) {
					if (pieceAt(i, j).isFire()) {
						fireExist = true;
					} else {
						waterExist = true;
					}
				}
			}
		}

		if (!fireExist && !waterExist) {
			return "No one";
		}
		if (fireExist && !waterExist) {
			return "Fire";
		}
		if (!fireExist && waterExist) {
			return "Water";
		}
		return null;
	}

	/* Draws a N * N board in gray and red color. */
	private static void drawBoard(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i + j) % 2 == 0) {
					StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				} else {
					StdDrawPlus.setPenColor(StdDrawPlus.RED);
				}
				StdDrawPlus.filledSquare(i + .5, j + .5, .5);
			}
		}
	}

	/* Draw pieces using the current configuration. */
	private void drawPieces(Piece p, int x, int y) {
		String img = "";
		if (p != null) {
			if (p.isFire()) {
				if (p.isBomb()) {
					if (p.isKing()) {
						img = "img/bomb-fire-crowned.png";
					} else {
						img = "img/bomb-fire.png";
					}
				} else if (p.isShield()) {
					if (p.isKing()) {
						img = "img/shield-fire-crowned.png";
					} else {
						img = "img/shield-fire.png";
					}					
				} else {
					if (p.isKing()) {
						img = "img/pawn-fire-crowned.png";
					} else {
						img = "img/pawn-fire.png";
					}						
				}
			} else {
				if (p.isBomb()) {
					if (p.isKing()) {
						img = "img/bomb-water-crowned.png";
					} else {
						img = "img/bomb-water.png";
					}
				} else if (p.isShield()) {
					if (p.isKing()) {
						img = "img/shield-water-crowned.png";
					} else {
						img = "img/shield-water.png";
					}					
				} else {
					if (p.isKing()) {
						img = "img/pawn-water-crowned.png";
					} else {
						img = "img/pawn-water.png";
					}						
				}
			}
		}
		if (img != "") {
			StdDrawPlus.picture(x + .5, y + .5, img, 1, 1);
		}
	}

	/* Redraw the board with new configuration of pieces. */
	private void updateBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				drawPieces(pieces[i][j], i, j);
			}
		}		
	}
}