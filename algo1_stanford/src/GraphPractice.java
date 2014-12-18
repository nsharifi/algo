/**
 * Created by naser on 12/9/14.
 */
public class GraphPractice {
    private static boolean[] explored;
    private static Stack stack = new Stack();
    private static Queue q = new Queue();

    public static void bfs(Graph g, int s) {
        q.enqueue(s);
        explored[s] = true;
        while(!q.isEmpty()) {
            int v = q.dequeue();
            for(int w : g.getAdj(v)) {
                if(!explored[w]) {
                    explored[w] = true;
                    q.enqueue(w);
                    System.out.print("->" + w);
//                    bfs(g, w);
                }
            }
        }
    }
    public static void dfs(Graph g, int s) {
        stack.push(s);
        while(!stack.isEmpty()) {
            int v = stack.pop();
            explored[v] = true;
            for(int w : g.getAdj(v)) {
                if(!explored[w]) {
                    System.out.print("->" + w);
                    dfs(g, w);
                }
            }
        }
    }
    public static void main(String[] args){
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        explored = new boolean[g.N()];
        System.out.print(0);
//        dfs(g, 0);
        bfs(g, 0);
    }
}
