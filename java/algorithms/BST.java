package algorithms;

public class BST
{
    private BTNode<Integer> root;
    
    public BST()
    {
        root = null;
    }
    
    public boolean find(Integer i)
    {
        BTNode<Integer> n = root;
        boolean found = false;
        
        while (n != null && !found)
        {
            int comp = i.compareTo(n.data);
            if (comp == 0)
            {
                found = true;
            }
            else if (comp < 0)
            {
                n = n.left;
            }
            else
            {
                n = n.right;
            }
        }
        
        return found;
    }
    
    public boolean insert(Integer i)
    {
        BTNode<Integer> parent = root, child = root;
        boolean goneLeft = false;
        
        while (child != null && i.compareTo(child.data) != 0)
        {
            parent = child;
            if (i.compareTo(child.data) < 0)
            {
                child = child.left;
                goneLeft = true;
            }
            else
            {
                child = child.right;
                goneLeft = false;
            }
        }
        
        if (child != null)
        {
            return false;  // number already present
        }
        else
        {
            BTNode<Integer> leaf = new BTNode<Integer>(i);
            if (parent == null) // tree was empty
            {
                root = leaf;
            }
            else if (goneLeft)
            {
                parent.left = leaf;
            }
            else
            {
                parent.right = leaf;
            }
            return true;
        }
    }
    
    /**
     * Count the number of non - leaf nodes in the tree
     *
     * @return - The number of non - leaf nodes as int
     */
    public int nonleaves()
    {
        if (root == null)
        {
            return 0;
        }
        if (root.left == null && root.right == null)
        {
            return 1;
        }
        else
        {
            return countNonLeaves(this.root);
        }
    }
    
    /**
     * Find the max depth of the tree
     *
     * @return - The depth of the tree as int
     */
    public int depth()
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            return findDepth(this.root);
        }
    }
    
    /**
     * Count the number of nodes that have a value in the specified range (inclusive)
     *
     * @param min - Minimum value for the range as int
     * @param max - Maximum value for the range as int
     *
     * @return - Number of nodes in that range as int
     */
    public int range(int min, int max)
    {
        if (max < min)
        {
            throw new IllegalArgumentException();
        }
        
        if (root == null)
        {
            return 0;
        }
        else
        {
            return countInRange(this.root, min, max);
        }
    }
    
    /**
     * Count the number of non - leaf nodes in the tree recursively
     *
     * @param root - The root of the tree
     *
     * @return - Number of non - leaf nodes as int
     */
    private int countNonLeaves(BTNode root)
    {
        int count = 1;
        
        if (root.left == null && root.right == null)
        {
            return 0;
        }
        
        if (root.left != null)
        {
            count = count + countNonLeaves(root.left);
        }
        
        if (root.right != null)
        {
            count = count + countNonLeaves(root.right);
        }
        
        return count;
    }
    
    /**
     * Find the depth of the tree recursively
     *
     * @param root - The root of the tree
     *
     * @return - Depth as int
     */
    private int findDepth(BTNode<Integer> root)
    {
        int leftCount = 0;
        int rightCount = 0;
        
        if (root.left == null && root.right == null)
        {
            return 1;
        }
        
        if (root.left != null)
        {
            leftCount = findDepth(root.left);
        }
        
        if (root.right != null)
        {
            rightCount = findDepth(root.right);
        }
        
        return Math.max(leftCount, rightCount) + 1;
    }
    
    /**
     * Count the number of nodes that have a value in the specified range (inclusive) recursively
     *
     * @param root - The root of the tree
     * @param min  - Minimum value for the range as int
     * @param max  - Maximum value for the range as int
     *
     * @return - Number of nodes in that range as int
     */
    private int countInRange(BTNode<Integer> root, int min, int max)
    {
        if (root == null)
        {
            return 0;
        }
        
        if (root.data > max)
        {
            return countInRange(root.left, min, max);
        }
        
        if (root.data < min)
        {
            return countInRange(root.right, min, max);
        }
        
        return 1 + countInRange(root.left, min, max) + countInRange(root.right, min, max);
    }
}

class BTNode <T>
{
    T data;
    BTNode<T> left, right;
    
    BTNode(T o)
    {
        data = o;
        left = right = null;
    }
}
