import java.util.ArrayList;
import java.util.List;

/**
 * Created by naser on 11/11/14.
 */
public class DFS {
    private int[] labels;
    private boolean[] explored;
    private List<Edge> path = new ArrayList<Edge>();
    Stack stack = new Stack();
    private static int curLabel = 0;

    private void setExplored(int n) {
        this.explored = new boolean[n];
    }

    public void dfs(Graph g, int s) {
        explored[s] = true;
        stack.push(s);
        while(!stack.isEmpty()) {
            int v = stack.pop();
            for(int w : g.getAdj(v)) {
                if(!explored[w]) {
                    System.out.print("->" + w);
                    path.add(new Edge(v, w));
                    dfs(g, w);
                }
            }
        }
    }

    public void topoOrder(DiGraph g, int s) {

        for (int v : g.getAdj(s)) {
            if (!explored[v]) {
                explored[v] = true;
                topoOrder(g, v);
            }
        }
        System.out.print(curLabel + " ");
        labels[s] = curLabel++;
    }

    private void sccDFS(DiGraph g, int i) {
        explored[i] = true;
        leader[i] = s;
        for (int j : g.getAdj(i)) {
            if (!explored[j]) {
                sccDFS(g, j);
            }
        }
        t++;
        finishingTime[i] = t;
    }
    private void sccDfsLoop(DiGraph g) {
        t = 0;
        s = -1;
        for (int i = g.N()-1; i >= 0; i--) {
            if (!explored[i]) {
                s = i;
                sccDFS(g, i);
            }
        }
    }

    private int[] finishingTime;
    private static int[] leader;
    private int t;
    private int s;

    public void scc(DiGraph g) {
        finishingTime = new int[g.N()];
        leader = new int[g.N()];
        DiGraph rev = reverse(g);
        sccDfsLoop(rev);
        for (int i = 0; i < finishingTime.length; i++) {
            System.out.print(finishingTime[i] + " ");
        }
        System.out.println();
        sccDfsLoop(g);
        for (int i = 0; i < leader.length; i++) {
            System.out.print(leader[i] + " ");
        }
    }

    public static void main(String[] args) {
//        Graph g = new Graph(6);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(1, 3);
//        g.addEdge(2, 4);
//        g.addEdge(3, 4);
//        g.addEdge(3, 5);
//        g.addEdge(4, 5);
        DFS dfs = new DFS();
//        dfs.setExplored(g.N());
//        System.out.print(0);
//        dfs.dfs(g, 0);
//        DiGraph g1 = new DiGraph(4);
//        g1.addEdge(0, 2);
//        g1.addEdge(0, 3);
//        g1.addEdge(2, 1);
//        g1.addEdge(3, 1);
//        dfs.labels = new int[g1.N()];
//        dfs.setExplored(g1.N());
//        dfs.topoOrder(g1, 0);

        List<String> lines = FileService.readLines("./src/SCC.txt");
        DiGraph dg = new DiGraph(lines.size());
        for (String line : lines) {
            String[] edge = line.split("\\s+");
            dg.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }
        System.out.println(dg);
//        dg.addEdge(0, 6);
//        dg.addEdge(6, 3);
//        dg.addEdge(3, 0);
//        dg.addEdge(6, 8);
//        dg.addEdge(8, 5);
//        dg.addEdge(5, 2);
//        dg.addEdge(2, 8);
//        dg.addEdge(5, 7);
//        dg.addEdge(7, 1);
//        dg.addEdge(1, 4);
//        dg.addEdge(4, 7);
//        dfs.setExplored(dg.N());
//        dfs.scc(dg);

    }

    private DiGraph reverse(DiGraph g) {
        DiGraph rev = new DiGraph(g.N());
        for (int v = 0; v < g.N(); v++) {
            for (int w : g.getAdj(v)) {
                rev.addEdge(w, v);
            }
        }
        return rev;
    }
}
