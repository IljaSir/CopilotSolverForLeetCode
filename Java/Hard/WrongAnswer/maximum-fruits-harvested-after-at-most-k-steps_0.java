class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int[] pos = new int[n];
        int[] amount = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            amount[i] = fruits[i][1];
        }
        int res = 0;
        int left = startPos, right = startPos;
        int leftSum = 0, rightSum = 0;
        int leftPos = 0, rightPos = 0;
        while (leftPos < n && pos[leftPos] < startPos) {
            leftPos++;
        }
        while (rightPos < n && pos[rightPos] <= startPos) {
            rightPos++;
        }
        while (leftPos >= 0 || rightPos < n) {
            if (leftPos >= 0 && (rightPos == n || startPos - pos[leftPos] <= pos[rightPos] - startPos)) {
                leftSum += amount[leftPos];
                leftPos--;
            } else {
                rightSum += amount[rightPos];
                rightPos++;
            }
            res = Math.max(res, leftSum + rightSum);
            if (leftPos >= 0 && rightPos < n && pos[rightPos] - pos[leftPos] > k) {
                break;
            }
        }
        return res;
    }
}