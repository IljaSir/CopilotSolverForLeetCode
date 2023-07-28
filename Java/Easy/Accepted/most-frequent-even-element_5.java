class Solution {
    public int mostFrequentEven(int[] nums) {
        
        int[] count = new int[100001];
        for (int num : nums) {
            count[num]++;
        }
        int max = 0;
        int res = -1;
        for (int i = 0; i < 100001; i += 2) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}