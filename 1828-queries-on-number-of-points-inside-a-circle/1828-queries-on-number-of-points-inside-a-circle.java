class KDtree {
    Node root;
    int k = 2;

    KDtree() {
        this.root = null;
    }

    Node add(int depth, Node root, int[] cords) {
        if (root == null) {
            return new Node(cords);
        }

        int cd = depth % k;

        if (cords[cd] <= root.points[cd]) {
            root.left = add(depth + 1, root.left, cords);
        } else {
            root.right = add(depth + 1, root.right, cords);
        }

        return root;
    }

    int distance(int[] p1, int[] p2) {
        int xd = p1[0] - p2[0];
        int yd = p1[1] - p2[1];
        return (xd * xd) + (yd * yd);
    }

    int findLesser(Node root, int[] point, int radiusSquared, int depth) {
        if (root == null) return 0;

        int count = 0;
        if (distance(root.points, point) <= radiusSquared) {
            count++;
        }

        int cd = depth % k;
        int diff = point[cd] - root.points[cd];

        if (diff <= 0) {
            count += findLesser(root.left, point, radiusSquared, depth + 1);
            if (diff * diff <= radiusSquared) {
                count += findLesser(root.right, point, radiusSquared, depth + 1);
            }
        } else {
            count += findLesser(root.right, point, radiusSquared, depth + 1);
            if (diff * diff <= radiusSquared) {
                count += findLesser(root.left, point, radiusSquared, depth + 1);
            }
        }

        return count;
    }
}

class Node {
    int[] points;
    Node left;
    Node right;

    Node(int[] points) {
        this.points = points;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        KDtree tree = new KDtree();
        for (int[] p : points) {
            tree.root = tree.add(0, tree.root, p);
        }

        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] q : queries) {
            int[] center = new int[]{q[0], q[1]};
            int radiusSquared = q[2] * q[2];
            ans[index++] = tree.findLesser(tree.root, center, radiusSquared, 0);
        }

        return ans;
    }
}