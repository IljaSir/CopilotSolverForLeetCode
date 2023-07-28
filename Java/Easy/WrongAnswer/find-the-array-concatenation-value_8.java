class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        long res = 0;
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (i == j) {
                res = res * 10 + nums[i];
                break;
            }
            int first = nums[i];
            int last = nums[j];
            int firstLen = 1;
            int lastLen = 1;
            while (first >= 10) {
                firstLen++;
                first /= 10;
            }
            while (last >= 10) {
                lastLen++;
                last /= 10;
            }
            res = res * (long) Math.pow(10, firstLen + lastLen) + nums[i] * (long) Math.pow(10, lastLen) + nums[j];
            i++;
            j--;
        }
        return res;
    }
}