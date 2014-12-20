import java.util.List;

/**
 * Created by naser on 11/16/14.
 */
public class KosarajuSCC {
    DiGraph g;
    boolean[] explored;
    Stack stack = new Stack();

    public KosarajuSCC(int n) {
        g = new DiGraph(n);
        explored = new boolean[n];
    }

    public void dfs(DiGraph g, int s) {
        explored[s] = true;
        stack.push(s);
        while(!stack.isEmpty()) {
            int v = stack.pop();
            for(int w : g.getAdj(v)) {
                if(!explored[w]) {
//                    System.out.print("->" + w);
//                    path.add(new Edge(v, w));
                    dfs(g, w);
                }
            }
        }
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
    private boolean containsAll(Stack s, DiGraph g) {
        if(s.size() != g.N()) return false;
        return true;
    }
    public void kscc(DiGraph g) {
        Stack s = new Stack();
        for(int i = 0; i < g.N() && !containsAll(s, g); i++){
            if(!s.contains(i)) {
                dfs(g, i);
                s.push(i);
            }
        }
        DiGraph rev = reverse(g);
        while(!s.isEmpty()) {
            int v = s.pop();
            if(!explored[v]) {
                dfs(rev, v);
            }
        }
    }

    public static void main(String[] args) {
//        KosarajuSCC g = new KosarajuSCC(5);
        List<String> lines = FileService.readLines("./src/SCC.txt");
        KosarajuSCC scc = new KosarajuSCC(lines.size());
        for(String line : lines) {
            String[] edge = line.split(" ");
            scc.g.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }

    }
}
