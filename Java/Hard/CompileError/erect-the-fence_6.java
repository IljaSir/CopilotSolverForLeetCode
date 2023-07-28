class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        if (n <= 1) {
            return trees;
        }
        // Find the leftmost bottom point
        int leftBottom = 0;
        for (int i = 1; i < n; i++) {
            if (trees[i][0] < trees[leftBottom][0] || (trees[i][0] == trees[leftBottom][0] && trees[i][1] < trees[leftBottom][1])) {
                leftBottom = i;
            }
        }

        // Sort the points by polar angle
        Arrays.sort(trees, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int angleA = getAngle(a, trees[leftBottom]);
                int angleB = getAngle(b, trees[leftBottom]);
                if (angleA == angleB) {
                    return getDist(a, trees[leftBottom]) - getDist(b, trees[leftBottom]);
                }
                return angleA - angleB;
            }
        });

        // Find the convex hull
        Stack<Integer> stack = new Stack<>();
        stack.push(leftBottom);
        for (int i = 1; i < n; i++) {
            while (stack.size() >= 2 && crossProduct(trees[stack.get(stack.size() - 2)], trees[stack.peek()], trees[i]) < 0) {
                stack.pop();
            }
            stack.push(i);
        }

        // Remove the duplicate points
        Set<Integer> set = new HashSet<>();
        for (int i : stack) {
            set.add(i);
        }

        // Construct the result
        int[][] res = new int[set.size()][2];
        int idx = 0;
        for (int i : set) {
            res[idx++] = trees[i];
        }
        return res;
    }

    private int getAngle(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        if (x == 0) {
            return y >= 0 ? 90 : 270;
        }
        if (y == 0) {
            return x >= 0 ? 0 : 180;
        }
        int angle = (int) (Math.atan((double) y / x) * 180 / Math.PI);
        if (x >
    }
}