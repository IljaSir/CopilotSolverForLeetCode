class Solution {
    public int mostFrequentEven(int[] nums) {
        
        int[] counts = new int[100001];
        for (int num : nums) {
            counts[num]++;
        }
        int max = 0;
        int res = -1;
        for (int i = 0; i < counts.length; i++) {
            if (i % 2 == 0 && counts[i] > max) {
                max = counts[i];
                res = i;
            }
        }
        return res;
    }
}