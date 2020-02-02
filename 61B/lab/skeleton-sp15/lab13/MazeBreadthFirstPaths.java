import java.util.Observable;
/** 
 *  @author Josh Hug
 */

public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields: 
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze; 

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s; 
    }

    /** Conducts a breadth first search of the maze starting at vertex x. */
    private void bfs(int s) {
        if (s == t) {
            return;
        }
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < maze.V(); v++) {
            distTo[v] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;
        marked[s] = true;
        announce();
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            if (v == t) {
                return;
            }
            for (int w : maze.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    announce();
                    q.enqueue(w);
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs(s);
    }
} 

