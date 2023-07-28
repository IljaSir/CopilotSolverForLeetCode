class Solution {
    public int maxEqualFreq(int[] nums) {
        
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int c = count.getOrDefault(n, 0);
            count.put(n, c + 1);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
            freq.put(c + 1, freq.getOrDefault(c + 1, 0) + 1);
            if (freq.get(c) == 0) {
                freq.remove(c);
            }
            if (freq.size() == 2) {
                int a = freq.keySet().iterator().next();
                int b = freq.keySet().iterator().next();
                if (freq.get(a) == 1 && a == 1 || freq.get(b) == 1 && b == 1) {
                    max = i + 1;
                } else if (freq.get(a) == 1 && a == c + 1 || freq.get(b) == 1 && b == c + 1) {
                    max = i + 1;
                }
            } else if (freq.size() == 1) {
                int a = freq.keySet().iterator().next();
                if (freq.get(a) == 1 || a == 1) {
                    max = i + 1;
                }
            }
        }
        return max;
    }
}