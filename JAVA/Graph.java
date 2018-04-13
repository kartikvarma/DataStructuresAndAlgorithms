import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

public class Graph {
  // array of Adjacency Lists
  private LinkedList<Integer> adj[];

  // constructor with number of vertices
  @SuppressWarnings("unchecked")
  Graph(int vertices) {
    // this.vertices = vertices;
    adj = new LinkedList[vertices];
    for (int i = 0; i < vertices; i++) {
      adj[i] = new LinkedList<Integer>();
    }
  }

  // add a new edge between vertices v and u
  void addEdge(int v, int u) {
    adj[v].add(u);
    adj[u].add(v);
  }

  // breadth for traversal from a given source
  void bfs(int source) {
    // Map to keep track of all the vistied vertices;
    Map<Integer, Boolean> visitMap = new HashMap<>();
    // Temporary storage of element while traversing the graph
    Queue<Integer> queue = new LinkedList<>();
    visitMap.put(source, true);
    queue.add(source);

    while (!queue.isEmpty()) {
      source = queue.poll();
      System.out.println(source + " ");

      Iterator<Integer> it = adj[source].listIterator();

      while (it.hasNext()) {
        int n = it.next();

        if (!visitMap.containsKey(n)) {
          visitMap.put(n, true);
          queue.add(n);
        }
      }
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph(11);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(4, 5);
    g.addEdge(5, 6);
    g.addEdge(5, 7);
    g.addEdge(3, 7);
    g.addEdge(0, 8);
    g.addEdge(6, 8);
    g.addEdge(7, 8);

    g.bfs(0);
  }
}
