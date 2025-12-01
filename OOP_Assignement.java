// package assignment2java;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OOP_Assignement {
        
////////////////////////////         BST ASSIGNMENT       ////////////////////////////////////

    static int[][] tree;
    static int size = 0;

    final static int leftchild = 0;
    final static int node = 1;
    final static int rightChild = 2;

    // --------------------- Load Tree From File ---------------------
    public static void loadTreeFromFile(String fileName) {
        List<int[]> tempList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+"); // split by spaces
                if (parts.length == 3) {
                    int left = Integer.parseInt(parts[0]);
                    int value = Integer.parseInt(parts[1]);
                    int right = Integer.parseInt(parts[2]);
                    tempList.add(new int[]{left, value, right});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        size = tempList.size();
        tree = new int[size][3];

        for (int i = 0; i < size; i++) {
            tree[i] = tempList.get(i);
        }

        System.out.println("Tree loaded successfully. Total nodes: " + size);
    }

    // --------------------- In-Order Traversal ---------------------
    static void inOrderTraversal(int nodeRow) {
        if (nodeRow == -1) return;

        if (tree[nodeRow][leftchild] != -1) {
            inOrderTraversal(tree[nodeRow][leftchild]);
        }

        System.out.print(tree[nodeRow][node] + " -> ");

        if (tree[nodeRow][rightChild] != -1) {
            inOrderTraversal(tree[nodeRow][rightChild]);
        }
    }
   // ----------pre orderr--------------
static void preorder(int noderow){
    if(noderow==-1){
        return;
    }
    System.out.println(tree[noderow][node]+"->");

    if(tree[noderow][leftchild]!=-1){
        preorder(tree[noderow][leftchild]);
    }
  if(tree[noderow][rightChild]!=-1){
        preorder(tree[noderow][rightChild]);
    }

}
//-------------post order-------------
static void postorder(int noderow){
    if(noderow==-1){
        return;
    }
    if(tree[noderow][leftchild]!=-1){
        postorder(tree[noderow][leftchild]);
    }
  
    if(tree[noderow][rightChild]!=-1){
        postorder(tree[noderow][rightChild]);
    }

    System.out.println(tree[noderow][node]+"->");
}



    // --------------------- Main ---------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Load tree from file
        System.out.print("Enter tree file name (e.g., tree.txt): ");
        String fileName = scanner.nextLine();
        loadTreeFromFile(fileName);

        System.out.println("\nPlease choose from the following:");
        System.out.println("1) Print LEAF NODES of the given tree");
        System.out.println("2) Search given tree for a number and print its index if found");
        System.out.println("3) Search for a number in tree and return its Parent node and Child Node");
        System.out.println("4) Print nodes of the given tree using IN ORDER TRAVERSAL");
        System.out.print("\nEnter Number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // --------------------- Choice 1: Leaf Nodes ---------------------
        if (choice == 1) {
            System.out.println("\nLEAF NODES OF THE GIVEN TREE:");
            ArrayList<Integer> leafNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (tree[i][leftchild] == -1 && tree[i][rightChild] == -1) {
                    leafNodes.add(tree[i][node]);
                }
            }

            leafNodes.forEach(System.out::println);
        }

        // --------------------- Choice 2: Search Value ---------------------
        else if (choice == 2) {
            System.out.print("Enter number you want to search for: ");
            int numChoice = scanner.nextInt();
            boolean found = false;

            for (int i = 0; i < size; i++) {
                if (tree[i][node] == numChoice) {
                    System.out.println(numChoice + " was FOUND in the tree. Its index is " + i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(numChoice + " was NOT FOUND in the tree");
            }
        }

        // --------------------- Choice 3: Parent and Child Nodes ---------------------
        else if (choice == 3) {
            System.out.print("Enter number you want to search for: ");
            int numChoice = scanner.nextInt();

            boolean ifExists = false;
            int parentNode = -1;
            int leftchildNode = -1;
            int rightchildNode = -1;
            int leftchildNodeIndex = -1;
            int rightchildIndex = -1;
            int nodeIndex = -1;

            // Find the node
            for (int i = 0; i < size; i++) {
                if (tree[i][node] == numChoice) {
                    ifExists = true;
                    leftchildNodeIndex = tree[i][leftchild];
                    rightchildIndex = tree[i][rightChild];
                    nodeIndex = i;
                    break;
                }
            }

            if (!ifExists) {
                System.out.println("Number doesn't exist in tree");
                scanner.close();
                return;
            }

            // Find the parent
            for (int i = 0; i < size; i++) {
                if (tree[i][leftchild] == nodeIndex || tree[i][rightChild] == nodeIndex) {
                    parentNode = tree[i][node];
                    break;
                }
            }

            // Find left and right child values
            if (leftchildNodeIndex != -1) {
                leftchildNode = tree[leftchildNodeIndex][node];
            }
            if (rightchildIndex != -1) {
                rightchildNode = tree[rightchildIndex][node];
            }

            System.out.println("\nSelected Number = " + numChoice + " -> " + nodeIndex + " (index)");
            System.out.println("Parent Node = " + (parentNode == -1 ? "None (root)" : parentNode));
            System.out.println("Left Child Node = " + (leftchildNode == -1 ? "None" : leftchildNode));
            System.out.println("Right Child Node = " + (rightchildNode == -1 ? "None" : rightchildNode));
        }

        // --------------------- Choice 4: In-Order Traversal ---------------------
        else if (choice == 4) {
            System.out.println("\nIN ORDER TRAVERSAL:");
            inOrderTraversal(0);
            System.out.println(); 
        }

        scanner.close();
    }
}