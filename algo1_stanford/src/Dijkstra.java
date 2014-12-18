import java.util.*;

public class Dijkstra {
    private WeightedDigraph g;

    public Dijkstra(int n) {
        g = new WeightedDigraph(n);
    }

    public void dijkstra(WeightedDigraph g, int s) {
        List<Integer> V = new ArrayList<Integer>();
        for(int i = 0; i < g.N(); i++) V.set(i, i);

        Set<Integer> X = new TreeSet<Integer>();
        X.add(s);

        List<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < g.N(); i++)
            A.set(i, Integer.MAX_VALUE);
        A.set(s, 0);

        for (int v = s; v < g.N();) {
            for (WeightedEdge e : g.getAdj(v)) {
            }
        }
    }


    public static void main(String[] args){
        Dijkstra dijk = new Dijkstra(4);
        dijk.g.addEdge(new WeightedEdge(0, 1, 6));
        dijk.g.addEdge(new WeightedEdge(0, 2, 4));
        dijk.g.addEdge(new WeightedEdge(1, 2, 1));
        dijk.g.addEdge(new WeightedEdge(1, 3, 4));
        dijk.g.addEdge(new WeightedEdge(2, 3, 2));
        dijk.dijkstra(dijk.g, 0);
    }
}