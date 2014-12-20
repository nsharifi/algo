/**
 * Created by naser on 11/13/14.
 */
class Edge {
    private int either;
    private  int other;

    Edge(int v1, int v2) {
        either = v1;
        other = v2;
    }

    @Override
    public String toString() {
        return either + "->" + other;
    }
}
