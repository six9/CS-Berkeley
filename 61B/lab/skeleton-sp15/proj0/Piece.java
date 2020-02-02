import java.lang.Math;

public class Piece {
	private boolean fire;
	private Board b;
	private int x;
	private int y;
	private String type;
	private boolean king = false;
	private boolean captured = false;

	/* Constructor for a piece. */
	public Piece(boolean isFire, Board b, int x, int y, String type) {
		this.fire = isFire;
		this.b = b;
		this.b.place(this, x, y); // Places this piece on board.
		this.x = x;
		this.y = y;
		this.type = type;
	}

	/* Returns whether or not the piece is a fire piece. */
	public boolean isFire() {
		return fire;
	}

	/* Returns 0 if the piece is a fire piece, or 1 if the piece is a water piece. */
	public int side() {
		return fire ? 0 : 1;
	}

	/* Returns whether or not the piece has been crowned. */
	public boolean isKing() {
		return king;
	}

	/* Returns whether or not the piece is a Bomb Piece. */
	public boolean isBomb() {
		return type == "bomb";
	}

	/* Returns whether or not the piece is a Shield Piece. */
	public boolean isShield() {
		return type == "shield";
	}

	/* Assumes this Piece's movement from its current position to (x, y) is valid. */
	public void move(int x, int y) {
		if ((fire && y == 7) || (!fire && y == 0)) {
			king = true;
		}
		int xp = this.x;
		int yp = this.y;
		if ((x - xp) * (x - xp) + (y - yp) * (y - yp) == 8) {
			int xm = (x + xp) / 2;
			int ym = (y + yp) / 2;
			b.remove(xm, ym);
			captured = true;
		}
		this.x = x;
		this.y = y;
		b.place(this, x, y);
	}

	/* Returns whether or not this Piece has captured another piece this turn. */
	public boolean hasCaptured() {
		return captured;
	}
	
	/* Called at the end of each turn on the Piece that moved. 
	 * Makes sure the piece's hasCaptured() value returns to false. */
	public void doneCapturing() {
		captured = false;
	}
}