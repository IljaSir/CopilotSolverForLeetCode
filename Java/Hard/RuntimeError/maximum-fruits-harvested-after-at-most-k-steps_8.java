class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int start = startPos;
        int end = startPos;
        int total = fruits[start][1];
        int max = total;
        int steps = 0;
        while (steps < k) {
            int left = start - 1;
            int right = end + 1;
            if (left < 0 && right >= n) {
                break;
            }
            int leftSteps = left < 0 ? Integer.MAX_VALUE : fruits[start][0] - fruits[left][0];
            int rightSteps = right >= n ? Integer.MAX_VALUE : fruits[right][0] - fruits[end][0];
            if (leftSteps < rightSteps) {
                if (fruits[left][0] == fruits[start][0]) {
                    total += fruits[left][1];
                    start = left;
                } else {
                    total = fruits[left][1];
                    start = left;
                    end = left;
                }
            } else {
                if (fruits[right][0] == fruits[end][0]) {
                    total += fruits[right][1];
                    end = right;
                } else {
                    total = fruits[right][1];
                    start = right;
                    end = right;
                }
            }
            max = Math.max(max, total);
            steps++;
        }
        return max;
    }
}