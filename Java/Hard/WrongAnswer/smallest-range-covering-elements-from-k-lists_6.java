class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int N = nums.size();
        int[] indexes = new int[N];
        int[] min = new int[N];
        int[] max = new int[N];
        int[] result = new int[2];
        int minMax = Integer.MAX_VALUE;
        int maxMin = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            min[i] = nums.get(i).get(0);
            max[i] = nums.get(i).get(nums.get(i).size() - 1);
            if (min[i] < min[minIndex]) {
                minIndex = i;
            }
            if (max[i] > max[maxIndex]) {
                maxIndex = i;
            }
        }
        minMax = max[minIndex];
        maxMin = min[maxIndex];
        while (true) {
            if (minMax - maxMin < result[1] - result[0]) {
                result[0] = maxMin;
                result[1] = minMax;
            }
            if (indexes[minIndex] == nums.get(minIndex).size() - 1) {
                break;
            }
            indexes[minIndex]++;
            if (nums.get(minIndex).get(indexes[minIndex]) > minMax) {
                minMax = nums.get(minIndex).get(indexes[minIndex]);
            }
            maxMin = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (nums.get(i).get(indexes[i]) < maxMin) {
                    maxMin = nums.get(i).get(indexes[i]);
                    maxIndex = i;
                }
            }
        }
        return result;
    }
}