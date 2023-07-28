class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        int i = 0, j = nums.length - 1;
        long res = 0;
        while (i <= j) {
            int n1 = nums[i], n2 = nums[j];
            if (i == j) {
                res = res * 10 + n1;
                break;
            }
            res = res * 100 + n1 * 10 + n2;
            i++;
            j--;
        }
        return res;
    }
}