import java.util.*;

public class Solution9 {
    public static class Graph {

        ArrayList<ArrayList<Integer>> adjList; // number of vertices = size of adjList

        //inEdges
        public Graph(int numOfVertices) {
            adjList = new ArrayList<>();
            for (int i = 0; i < numOfVertices; ++i) {
                adjList.add(new ArrayList<>());
            }
        }

        //addEdges
        public void addEdge(int from, int to) {
            adjList.get(from).add(to);
        }
    }

    /**
     * The method for you to implement.
     */
    public int shortestPath(Graph g, int start, int end) {
        // TODO
        int v = 10;
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int min = 0;

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Integer numOfVertice = queue.remove();

                List<Integer> childList = g.adjList.get(numOfVertice);
                for (Integer child : childList) {
                    if (child == end) {
                        return ++min;
                    }
                    if (!visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }
                size--;
            }
            min++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(3, 2);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(6, 3);
        Solution9 solution = new Solution9();
        System.out.println(solution.shortestPath(graph, 0 , 3)); // should be 2
        System.out.println(solution.shortestPath(graph, 0 , 1)); // should be 1
        System.out.println(solution.shortestPath(graph, 6 , 0)); // should be -1
    }
}

