class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        int res = 0;
        for (int i = 1; i <= max; i++) {
            if (count[i] == 0) {
                continue;
            }
            int gcd = i;
            for (int j = 2 * i; j <= max; j += i) {
                gcd = gcd(gcd, j);
            }
            if (gcd == i) {
                res++;
            }
        }
        return res;
    }
    
    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}