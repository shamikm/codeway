package org.maj.sm;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.maj.sm.TreeMisc.*;
/**
 * @author shamik.majumdar
 */
public class TreeMiscTest {
    private BinaryTree<Integer> binaryTree = new BinaryTree<>();
    private TreeNode<Integer> rootNode;

    @BeforeTest
    public void setUp(){
        TreeNode<Integer> node10 = binaryTree.createNode(10,null,null);
        TreeNode<Integer> node30 = binaryTree.createNode(30,null,null);
        TreeNode<Integer> node50 = binaryTree.createNode(50,null,null);
        TreeNode<Integer> node70 = binaryTree.createNode(70,null,null);

        TreeNode<Integer> node20 = binaryTree.createNode(20,node10,node30);
        TreeNode<Integer> node60 = binaryTree.createNode(60,node50,node70);
        TreeNode<Integer> node40 = binaryTree.createNode(40,node20,node60);

        rootNode = node40;

    }
    @Test
    public void testT(){
        List<Integer> accumulator = new ArrayList<>();
        binaryTree.preOrder(rootNode,accumulator);
        Assert.assertEquals(Arrays.asList(40,20,10,30,60,50,70),accumulator);
        accumulator.clear();
        binaryTree.preOrderIter(rootNode,accumulator);
        Assert.assertEquals(Arrays.asList(40,20,10,30,60,50,70),accumulator);
       /* binaryTree.postOrder(rootNode);
        binaryTree.inOrder(rootNode);*/
    }

    @Test
    public void testBFS(){
        List<Integer> accumulator = new ArrayList<>();
        binaryTree.bfs(rootNode,accumulator);
        Assert.assertEquals(Arrays.asList(40,20,60,10,30,50,70),accumulator);
    }

    @Test
    public void testDFS(){
        List<Integer> accumulator = new ArrayList<>();
        binaryTree.dfs(rootNode,accumulator);
        Assert.assertEquals(Arrays.asList(40,20,10,30,60,50,70),accumulator);
    }

    @Test
    public void testDepth(){
        Assert.assertEquals(binaryTree.depthOfATree(rootNode),3);
    }
}
