import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of layers:");
        int n = scan.nextInt();
        Dictionary<Integer, Integer> dict = new Hashtable<>();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the number of nodes in layer " + i + " :");
            int nodes = scan.nextInt();
            dict.put(i, nodes);
        }
        NeuralNetwork neuralNetwork = new NeuralNetwork(n, dict);
        neuralNetwork.setWeights(scan);
        System.out.println("enter the layer of the node whose edge weight should be found: ");
        int a=scan.nextInt();
        System.out.println("enter number of the node whose edge weight should be found: ");
        int b=scan.nextInt();
        System.out.println("enter the number of the node on the edge's other end in the next layer: ");
        int c=scan.nextInt();
        neuralNetwork.getWeights(a,b,c);
        scan.close();
    }
}

class NeuralNetwork {
    private int noOfLayers;
    private Dictionary<Integer, Integer> noOfNodes;
    private double[][][] weights;

    public NeuralNetwork(int noOfLayers, Dictionary<Integer, Integer> noOfNodes) {
        this.noOfLayers = noOfLayers;
        this.noOfNodes = noOfNodes;
        this.weights = new double[noOfLayers][][];
    }

    public void setWeights(Scanner scan) {
        for (int layer = 1; layer < noOfLayers; layer++) {
            int nodesInThisLayer = noOfNodes.get(layer);
            int nodesInNextLayer = noOfNodes.get(layer + 1);
            weights[layer - 1] = new double[nodesInThisLayer][nodesInNextLayer];
            for (int j = 0; j < nodesInThisLayer; j++) {
                for (int k = 0; k < nodesInNextLayer; k++) {
                    int layer2=layer+1;
                    int l=j+1;
                    int m=k+1;
                    System.out.println("Enter the weight of the edge from node " + l +" in layer " + layer +
                            " to node " + m + " in layer " + layer2 + ":");
                    weights[layer - 1][j][k] = scan.nextDouble();
                }
            }
        }
    }

    public void getWeights(int layerNo, int fromNode, int toNode) {
        if (layerNo==noOfLayers){
            System.out.println("this is the output layer");
        }
        else{
        System.out.println("The weight of the edge from node " + fromNode +
                " in layer " + layerNo + " to node " + toNode +
                " in layer " + (layerNo + 1) + " is " +
                weights[layerNo - 1][fromNode-1][toNode-1]);}
    }
}
