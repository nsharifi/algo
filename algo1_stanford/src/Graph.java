import java.util.ArrayList;
import java.util.List;

/**
 * Created by naser on 11/10/14.
 */
public class Graph {
    private final int n; // vertex count
    private int m;       // edge count
    private List<Integer>[] adj;

    public Graph(int n) {
        this.n = n;
        this.m = 0;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();
    }

    /**
     *
     * @param v Vertex whose adjacency list is required
     * @return The adjacency list of the vertex v
     */
    public List<Integer> getAdj(int v) {
        return adj[v];
    }

    /**
     *
     * @return Number of vertices
     */
    public int N() {
        return n;
    }

    /**
     *
     * @return Number of edges
     */
    public int M() {
        return m;
    }

    public void addEdge(int either, int other) {
        if (!adj[either].contains(other))
            adj[either].add(other);
        if (!adj[other].contains(either))
            adj[other].add(either);
        m += 1;
    }
//    public void addEdge(int either, int other) {
//        if (adj[either].contains(other))
//            return;
//        adj[either].add(other);
//        adj[other].add(either);
//        m += 1;
//    }
//    public void addEdge(int either, int other) {
//        adj[either].add(other);
//        m += 1;
//    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < adj.length; i++) {
            sb.append(i);
            for (int v : adj[i]) {
                sb.append("->" + v);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> lines = FileService.readLines("./src/kargerMinCut.txt");
        Graph g = new Graph(lines.size());
        String[] splitLine;
        for (String line : lines) {
            splitLine = line.split("\\s+");
            for (int i = 1; i < splitLine.length; i++)
                g.addEdge(Integer.parseInt(splitLine[0])-1, Integer.parseInt(splitLine[i])-1);
        }

        System.out.println(g);
    }

}

class Vertex {
    private final int value;
    private List<Vertex> adj = new ArrayList<Vertex>();

    public Vertex(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

