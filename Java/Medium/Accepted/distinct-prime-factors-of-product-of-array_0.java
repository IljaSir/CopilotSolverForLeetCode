class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            int[] factors = getFactors(num);
            for (int factor : factors) {
                count[factor]++;
            }
        }
        int res = 0;
        for (int num : count) {
            if (num > 0) {
                res++;
            }
        }
        return res;
    }
    
    private int[] getFactors(int n) {
        int[] res = new int[10];
        int index = 0;
        int i = 2;
        while (i * i <= n) {
            while (n % i == 0) {
                res[index++] = i;
                n /= i;
            }
            i++;
        }
        if (n > 1) {
            res[index++] = n;
        }
        return Arrays.copyOf(res, index);
    }
}