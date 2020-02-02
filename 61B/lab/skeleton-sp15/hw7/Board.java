public class Board {

    public static final int SIZE = 8;
    // You can call this variable by Board.SIZE.

	private Piece[][] pieces;
    private boolean isFireTurn;

    public Board() {
        pieces = new Piece[SIZE][SIZE];
        isFireTurn = true;
    }

    /** Makes a custom Board. Not a completely safe operation because you could do
    * some bad stuff here, but this is for the purposes of testing out hash
    * codes so let's forgive the author. 
    */
    public Board(Piece[][] pieces) {
        this.pieces = pieces;
        isFireTurn = true;
    }

	@Override
	public boolean equals(Object o) {
        if (o instanceof Board) {
            Board b = (Board) o;
            if (this.SIZE == b.SIZE && this.isFireTurn == b.isFireTurn) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (!this.pieces[i][j].equals(b.pieces[i][j])) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
	}

    /* Obviously not a good hashCode()! But I have no idea... */
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int k = (i + j) % 32;
                hash += pieces[i][j].hashCode() << k;
            }
        }
        return hash;
    }
}