class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int n = nums.size();
        int[] idx = new int[n];
        int[] min = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = nums.get(i).get(0);
            max[i] = nums.get(i).get(nums.get(i).size() - 1);
        }
        int[] ans = new int[2];
        int[] range = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        while (true) {
            int minIdx = 0;
            for (int i = 1; i < n; i++) {
                if (min[minIdx] > min[i]) {
                    minIdx = i;
                }
            }
            if (max[minIdx] - min[minIdx] < range[1] - range[0]) {
                range[0] = min[minIdx];
                range[1] = max[minIdx];
            }
            if (idx[minIdx] == nums.get(minIdx).size() - 1) {
                break;
            }
            min[minIdx] = nums.get(minIdx).get(++idx[minIdx]);
            max[minIdx] = Math.max(max[minIdx], min[minIdx]);
        }
        return range;
    }
}