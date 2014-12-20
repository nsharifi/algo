import java.util.ArrayList;
import java.util.List;

/**
 * Created by naser on 11/21/14.
 */
public class WeightedDigraph {
    private int m;
    private int n;
    private List<WeightedEdge>[] adj;

    public WeightedDigraph(int n) {
        this.n = n;
        m = 0;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<WeightedEdge>();
    }

    public List<WeightedEdge> getAdj(int v) {
        return adj[v];
    }

    public void addEdge(WeightedEdge e) {
        int v = e.getFrom();
        adj[v].add(e);
        m++;
    }

    public int M() { return m; }
    public int N() { return n; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (WeightedEdge e : adj[i]) {
                sb.append(e + " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedDigraph g = new WeightedDigraph(4);
        g.addEdge(new WeightedEdge(0, 1, 6));
        g.addEdge(new WeightedEdge(0, 2, 4));
        g.addEdge(new WeightedEdge(1, 2, 1));
        g.addEdge(new WeightedEdge(1, 3, 4));
        g.addEdge(new WeightedEdge(2, 3, 2));
        System.out.println(g);
    }
}

class WeightedEdge {
    private int from;
    private int to;
    private int weight;

    public WeightedEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + from + "->" + to +  ", " + weight +")";
    }
}