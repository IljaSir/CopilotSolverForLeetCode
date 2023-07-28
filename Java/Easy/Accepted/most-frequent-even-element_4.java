class Solution {
    public int mostFrequentEven(int[] nums) {
        
        int[] count = new int[100001];
        int max = 0;
        int res = -1;
        for (int n : nums) {
            if (n % 2 == 0) {
                count[n]++;
                if (count[n] > max || (count[n] == max && n < res)) {
                    max = count[n];
                    res = n;
                }
            }
        }
        return res;
    }
}