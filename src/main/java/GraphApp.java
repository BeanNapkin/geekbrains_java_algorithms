public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);
        graph.addEdge(1,7);

        long startTime = System.nanoTime();
        graph.dfs();
        long endTime = System.nanoTime();
        System.out.println("Время обхода графа в глубину: " + (endTime - startTime));

        startTime = System.nanoTime();
        graph.bfs();
        endTime = System.nanoTime();
        System.out.println("Время обхода графа в ширину: " + (endTime - startTime));


    }
}
