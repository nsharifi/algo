import java.util.ArrayList;
import java.util.List;

/**
 * Created by naser on 11/11/14.
 */
public class BFS {
    private boolean[] explored;

    private void setExplored(int n) {
        this.explored = new boolean[n];
    }

    public void bfs(Graph g, int s) {
        List<Edge> path = new ArrayList<Edge>();
        explored[s] = true;
        Queue q = new Queue();
        q.enqueue(s);
        while(!q.isEmpty()) {
            int v = q.dequeue();
            for(int w : g.getAdj(v)) {
                if(!explored[w]) {
                    explored[w] = true;
                    q.enqueue(w);
                    path.add(new Edge(v, w));
                }
            }
        }
        for (Edge e : path) {
            System.out.print(e + " ");
        }
    }

    public int[] shortestPath(Graph g, int s) {
        List<Edge> path = new ArrayList<Edge>();
        int[] dist = new int[g.N()];
        for(int i = 0; i < g.N(); i++) {
            dist[i] = i == s ? 0 : Integer.MAX_VALUE;
        }
        boolean[] explored = new boolean[g.N()];
        explored[s] = true;
        Queue q = new Queue();
        q.enqueue(s);
        while(!q.isEmpty()) {
            int v = q.dequeue();
            for(int w : g.getAdj(v)) {
                if(!explored[w]) {
                    explored[w] = true;
                    q.enqueue(w);
                    path.add(new Edge(v, w));
                    dist[w] = dist[v] + 1;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

        return dist;
    }

    public void connectedComponents(Graph g) {
        List<Edge> path = new ArrayList<Edge>();
        int compCount = 0;
        for (int i = 0; i < g.N(); i++) {
            if (!explored[i]) {
                bfs(g, i);
                compCount++;
            }
        }
        for (Edge e : path) {
            System.out.print(e + " ");
        }
        System.out.println("Components count: " + compCount);
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
//        Graph g = new Graph(6);
        Graph g = new Graph(10);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(2, 4);
        g.addEdge(4, 6);
        g.addEdge(4, 8);
        g.addEdge(1, 3);
        g.addEdge(5, 7);
        g.addEdge(5, 9);
        g.addEdge(7, 9);
        bfs.setExplored(g.N());
        bfs.connectedComponents(g);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 3);
//        g.addEdge(2, 3);
//        g.addEdge(2, 4);
//        g.addEdge(3, 4);
//        g.addEdge(3, 5);
//        g.addEdge(4, 5);
//        bfs.shortestPath(g, 0);
    }
}
