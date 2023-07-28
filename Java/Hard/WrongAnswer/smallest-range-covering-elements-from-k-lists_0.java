class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int k = nums.size();
        int[] idx = new int[k];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = max - min;
        int start = min;
        int end = max;
        boolean flag = true;
        while (flag) {
            flag = false;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            int minIdx = 0;
            for (int i = 0; i < k; i++) {
                if (idx[i] < nums.get(i).size() && nums.get(i).get(idx[i]) < min) {
                    min = nums.get(i).get(idx[i]);
                    minIdx = i;
                }
            }
            idx[minIdx]++;
            for (int i = 0; i < k; i++) {
                if (idx[i] < nums.get(i).size()) {
                    flag = true;
                    max = Math.max(max, nums.get(i).get(idx[i]));
                }
            }
            if (max - min < range) {
                range = max - min;
                start = min;
                end = max;
            }
        }
        return new int[]{start, end};
    }
}