package org.maj.sm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shamik.majumdar
 */
public class TreeMisc {
    static class TreeNode<T> {
        private final T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    static class BinaryTree<T> {
        public TreeNode<T> createNode(T data,TreeNode<T> left, TreeNode<T> right ){
            TreeNode<T> t = new TreeNode<>(data);
            t.left = left;
            t.right = right;
            return t;
        }
        public void preOrder(TreeNode<T> rootNode,List<T> accumulator){
            if (rootNode != null) {
                System.out.println(rootNode.data);
                accumulator.add(rootNode.data);
                preOrder(rootNode.left,accumulator);
                preOrder(rootNode.right,accumulator);
            }
        }
        public void preOrderIter(TreeNode<T> rootNode,List<T> accumulator){
            if (rootNode != null){
                Stack<TreeNode<T>> stack = new Stack<>();
                stack.push(rootNode);
                while(!stack.isEmpty()){
                    TreeNode<T> node = stack.pop();
                    accumulator.add(node.data);
                    if (node.right != null){
                        stack.push(node.right);
                    }
                    if (node.left != null){
                        stack.push(node.left);
                    }
                }
            }
        }
        public void postOrder(TreeNode<T> rootNode){
            if (rootNode != null) {
                postOrder(rootNode.left);
                postOrder(rootNode.right);
                System.out.println(rootNode.data);
            }
        }
        public void inOrder(TreeNode<T> rootNode){
            if (rootNode != null) {
                inOrder(rootNode.left);
                System.out.println(rootNode.data);
                inOrder(rootNode.right);
            }
        }

        public void bfs(TreeNode<T> rootNode,List<T> accumulator){
            Queue<TreeNode<T>> queue = new LinkedList<>();
            if (rootNode != null){
                queue.add(rootNode);
                while(!queue.isEmpty()){
                    TreeNode<T> t = queue.remove();
                    accumulator.add(t.data);
                    if (t.left != null) queue.add(t.left);
                    if (t.right != null) queue.add(t.right);
                }
            }
        }

        public void dfs(TreeNode<T> rootNode,List<T> accumulator){
            Stack<TreeNode<T>> stack = new Stack<>();
            if (rootNode != null){
                stack.add(rootNode);
                while(!stack.isEmpty()){
                    TreeNode<T> t = stack.pop();
                    accumulator.add(t.data);
                    if (t.right != null) stack.add(t.right);
                    if (t.left != null) stack.add(t.left);
                }
            }
        }

        public int depthOfATree(TreeNode<T> node){
            if (node == null) return 0;
            int left = node.left == null ? 0 : depthOfATree(node.left);
            int right = node.right == null ? 0 : depthOfATree(node.right);
            return left > right ? (left + 1) : (right +1);
        }
    }

}
