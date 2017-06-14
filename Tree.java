package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tree
{
    private static ArrayList<String> tree = new ArrayList<>();
    private static ArrayList<String> nodes = new ArrayList<>();
    private static ArrayList<String> edges = new ArrayList<>();
    public static void generateTree()
    {
        tree = readFile(tree);
        for(String line : tree)
        {
            if(line.split(",").length == 2)
            {
                generateNode(line, nodes);
            }
            else
            {
                generateEdge(line, edges);
            }
        }
    }

    public static String searchTree(String nodeLoc)
    {
        String nodeQ = setNode(nodeLoc);
        System.out.println(nodeQ);
        Scanner scanner = new Scanner(System.in);
        String[] currentNode = nodeLoc.split(",");
        String choice = scanner.nextLine();
        for(String edge : edges)
        {
            String[] currentEdge = edge.split(",");
            if(currentEdge[0].equals(currentNode[0]) && currentEdge[2].trim().equals(choice))
            {
                nodeLoc = currentEdge[1].trim();
            }
        }
        if(!setNode(nodeLoc).substring(setNode(nodeLoc).trim().length()).equals("?")) //NOT WORKING
        {
            nodeQ = setNode(nodeLoc);
            Search.search = false;
            System.out.println("Het blad dat u beschrijft is van een " + nodeQ.trim() + ".");
        }
       return nodeLoc;
    }

    private static String setNode(String nodeLoc)
    {
        String nodeQ = "";
        for(String node : nodes)
        {
            String[] currentNode = node.split(",");
            if(currentNode[0].equals(nodeLoc))
            {
                nodeQ = currentNode[1];
            }
        }
        return nodeQ;
    }

    private static void generateNode(String line, ArrayList<String> node)
    {
        node.add(line);
    }

    private static void generateEdge(String line, ArrayList<String> edge)
    {
        edge.add(line);
    }

    private static ArrayList<String> readFile(ArrayList<String> tree)
    {
        try
        {
            File boom = new File("Tree.txt");
            FileReader fileReader = new FileReader(boom);

            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null)
            {
                tree.add(line);
            }
            reader.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return tree;
    }
}
