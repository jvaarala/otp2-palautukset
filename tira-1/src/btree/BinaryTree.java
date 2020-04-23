package btree;

/**
 * @author kamaj  / jessevaa
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right) {
        root = new Node(rootValue, left, right);
    }

    public void insert(String aData) {
        if (root == null) {
            root = new Node(aData);
        } else if (aData.compareTo(root.getData()) < 0) {
            if (root.left() != null) {
                root.left().insert(aData);
            } else {
                this.setLeft(new BinaryTree(aData));
            }
        } else {
            if (root.right() != null) {
                root.right().insert(aData);
            } else {
                this.setRight(new BinaryTree(aData));
            }
        }

        this.root.setHeight(
                Math.max(
                        this.root.left() != null ? this.root.left().root.getHeight() : 0,
                        this.root.right() != null ? this.root.right().root.getHeight() : 0
                ) + 1
        );
    }

    public BinaryTree getSmallest(BinaryTree bt) {
        if (bt.root.left() == null) {
            return bt;
        } else return getSmallest(bt.root.left());
    }

    BinaryTree deleteNode(BinaryTree tree, String data) {
        BinaryTree treeToDelete = tree.find(data);
        if (treeToDelete == null) {
            return null;
        } else if (treeToDelete.root.left() == null && treeToDelete.root.right() == null) {
            treeToDelete.root = null;
        } else if (treeToDelete.root.left() != null && treeToDelete.root.right() != null) {
            BinaryTree treeTemp = treeToDelete;
            BinaryTree smallestAtRight = getSmallest(treeToDelete.root.right());
            treeToDelete.root.setData(smallestAtRight.root.getData());
            deleteNode(treeTemp.root.right(), smallestAtRight.root.getData());
        } else if (treeToDelete.root.left() != null) {
            treeToDelete.root = treeToDelete.root.left().root;
        } else if (treeToDelete.root.right() != null) {
            treeToDelete.root = treeToDelete.root.right().root;
        }
        return treeToDelete;
    }

    public BinaryTree find(String aData) {
        if (root.getData().contentEquals(aData)) {
            return this;
        }
        if (aData.compareTo(root.getData()) < 0) {
            System.out.print(" < ");
            return root.left().root == null ? null : root.left().find(aData);
        } else {
            System.out.print(" > ");
            return root.right().root == null ? null : root.right().find(aData);
        }
    }

    public void inOrder() {
        if (root != null) {
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().inOrder();
            System.out.println(root.getData() + ',' + "\th: " + root.getHeight());
            if (root.right() != null) // pääseekö oikealle?
                root.right().inOrder();
        }
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
