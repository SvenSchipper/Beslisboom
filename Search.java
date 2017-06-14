package com.company;
import java.io.*;
import java.util.*;

public class Search
{
    public static boolean search = true;
    public static void main(String[] args)
    {
        Tree.generateTree();
        String node = "N1";
        while (search)
        {
            node = Tree.searchTree(node);
        }
    }
}
