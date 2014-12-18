/**
 * Created by naser on 4/3/14.
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (int v : G.adj(s)) {
            if (!marked[v]) {
                edgeTo[v] = s;
                dfs(G, v);
            }
        }
    }

    public static void main(String[] args) {

    }
}
