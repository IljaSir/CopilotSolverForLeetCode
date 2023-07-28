class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + weights[i];
        }
        int[] min = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = i;
            max[i] = i;
        }
        for (int i = 1; i < k; i++) {
            int[] nextMin = new int[n];
            int[] nextMax = new int[n];
            int minIndex = 0;
            for (int j = 0; j < n; j++) {
                while (minIndex < j && preSum[j + 1] - preSum[minIndex] >= preSum[minIndex + 1] - preSum[min[minIndex]]) {
                    minIndex++;
                }
                nextMin[j] = min[minIndex];
                int maxIndex = max[j];
                while (maxIndex > 0 && preSum[maxIndex + 1] - preSum[j] >= preSum[max[maxIndex] + 1] - preSum[j]) {
                    maxIndex = max[maxIndex - 1];
                }
                nextMax[j] = maxIndex;
            }
            min = nextMin;
            max = nextMax;
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, preSum[max[i] + 1] - preSum[i] + preSum[n] - preSum[min[i]]);
        }
        return result;
    }
}