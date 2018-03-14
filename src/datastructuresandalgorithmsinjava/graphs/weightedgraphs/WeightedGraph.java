package datastructuresandalgorithmsinjava.graphs.weightedgraphs;


class Edge {
    public int srcVert;
    public int destVert;
    public int distance;

    public Edge(int sv, int dv, int d) {
        srcVert = sv;
        destVert = dv;
        distance = d;
    }
}

class PriorityQueue {
    private final int SIZE = 20;
    private Edge[] queueArray;
    private int size;

    public PriorityQueue() {
        queueArray = new Edge[SIZE];
        size = 0;
    }

    public void insert(Edge item) {
        int j;

        for (j = 0; j < size; j++) {
            if (item.distance >= queueArray[j].distance)
                break;
        }

        for (int k = size - 1; k >= j; k--) {
            queueArray[k+1] = queueArray[k];
        }
        queueArray[j] = item;
        size++;
    }

    public Edge removeMin() {
        return queueArray[--size];
    }

    public void removeN(int n) {
        for (int j=n; j < size-1; j++) {
            queueArray[j] = queueArray[j+1];
        }
        size--;
    }

    public Edge peekMin() {
        return queueArray[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Edge peekN(int n) {
        return queueArray[n];
    }

    public int find(int findDex) {
        for (int j = 0; j < size; j++) {
            if (queueArray[j].destVert == findDex)
                return j;
        }
        return -1;
    }
}

class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab) {
        label = lab;
        isInTree = false;
    }
}

public class WeightedGraph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int verts; // current number of vertices
    private int currentVert;
    private PriorityQueue thePQ;
    private int tree;

    public WeightedGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        verts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = INFINITY;
            }
        }
        thePQ = new PriorityQueue();
    }

    public void addVertex(char lab) {
        vertexList[verts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void mstw() {
        currentVert = 0;
        while (tree < verts - 1) {
            vertexList[currentVert].isInTree = true;
            tree++;

            for (int j = 0; j < verts; j++) {
                if (j == currentVert)
                    continue;
                if (vertexList[j].isInTree)
                    continue;
                int distance = adjMat[currentVert][j];
                if (distance == INFINITY)
                    continue;
                putInPriorityQueue(j, distance);
            }
            if (thePQ.size() == 0) {
                System.out.println("GRAPH NOT CONNECTED");
                return;
            }
            Edge theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;

            System.out.println( vertexList[sourceVert].label );
            System.out.println( vertexList[currentVert].label );
        }
        for (int j = 0; j < verts; j++) {
            vertexList[j].isInTree = false;
        }
    }

    public void putInPriorityQueue(int newVert, int newDist) {
        int queueIndex = thePQ.find(newVert);
        if (queueIndex != -1) {
            Edge tempEdge = thePQ.peekN(queueIndex);
            int oldDist = tempEdge.distance;
            if (oldDist > newDist) {
                thePQ.removeN(queueIndex);
                Edge theEdge = new Edge(currentVert, newVert, newDist);
                thePQ.insert(theEdge);
            }
        } else {
            Edge theEdge = new Edge(currentVert, newVert, newDist);
            thePQ.insert(theEdge);
        }
    }
}