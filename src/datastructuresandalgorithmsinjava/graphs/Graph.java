package datastructuresandalgorithmsinjava.graphs;


class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int verts; // current number of vertices
    private StackX theStack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        verts = 0;
        for (int j = 0; j < MAX_VERTS; ++j) {
            for(int k = 0; k < MAX_VERTS; ++k) {
                adjMat[j][k] = 0;
            }
        }
        theStack = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[verts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void dfc() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < verts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for(int j = 0; j < verts; j++)
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j;
        return -1;
    }
}
