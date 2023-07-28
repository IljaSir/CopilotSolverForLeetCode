class Solution {
    public int maxEqualFreq(int[] nums) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int f = freq.getOrDefault(num, 0);
            freq.put(num, f + 1);
            count.put(f, count.getOrDefault(f, 0) - 1);
            count.put(f + 1, count.getOrDefault(f + 1, 0) + 1);
            if (count.get(1) == i + 1) {
                res = i + 1;
            } else if (count.get(f) == 0) {
                res = i + 1;
            } else if (count.get(f) == -1 && count.get(1) == 1) {
                res = i + 1;
            } else if (count.get(f + 1) == 1 && f + 1 == i + 1) {
                res = i + 1;
            }
        }
        return res;
    }
}