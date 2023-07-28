class Solution {
    public boolean validPartition(int[] nums) {
        
        int len = nums.length;
        int[] counts = new int[1000001];
        int[] maxes = new int[1000001];
        int[] mins = new int[1000001];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int num : nums) {
            counts[num]++;
            maxes[num] = Math.max(maxes[num], num);
            mins[num] = Math.min(mins[num], num);
        }
        int[] freq = new int[4];
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                freq[counts[i]]++;
                if (freq[2] > 0 && freq[3] > 0) {
                    return true;
                }
                if (freq[3] > 0 && i - mins[i] == 2) {
                    return true;
                }
                if (freq[2] > 0 && maxes[i] - mins[i] == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}