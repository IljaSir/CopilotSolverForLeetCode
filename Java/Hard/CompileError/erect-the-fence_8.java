class Solution {
    public int[][] outerTrees(int[][] trees) {
        
        // 1. 找到最左下角的点
        int[] bottomLeft = trees[0];
        for (int i = 1; i < trees.length; i++) {
            if (trees[i][0] < bottomLeft[0]) {
                bottomLeft = trees[i];
            } else if (trees[i][0] == bottomLeft[0]) {
                if (trees[i][1] < bottomLeft[1]) {
                    bottomLeft = trees[i];
                }
            }
        }
        // 2. 以最左下角的点为基准，计算其他点与其的极角
        // 3. 以极角排序
        // 4. 以最左下角的点为起点，依次取点
        Arrays.sort(trees, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int angleA = getAngle(bottomLeft, a);
                int angleB = getAngle(bottomLeft, b);
                if (angleA == angleB) {
                    return getDistance(bottomLeft, a) - getDistance(bottomLeft, b);
                }
                return angleA - angleB;
            }
        });
        // 5. 去除极角相同的点
        int index = 1;
        for (int i = 2; i < trees.length; i++) {
            if (getAngle(bottomLeft, trees[i]) == getAngle(bottomLeft, trees[i - 1])) {
                continue;
            }
            trees[index++] = trees[i];
        }
        // 6. 依次取点，如果不构成凸包，删除
        int[] stack = new int[index];
        int top = 0;
        for (int i = 0; i < index; i++) {
            while (top >= 2 && !isConvex(stack[top - 2], stack[top - 1], trees[i])) {
                top--;
            }
            stack[top++] = i;
        }
        // 7. 输出结果
        int[][] result = new int[top][2];
        for (int i = 0; i < top; i++) {
            result[i] = trees[stack[i]];
        }
        return result;
    }
}