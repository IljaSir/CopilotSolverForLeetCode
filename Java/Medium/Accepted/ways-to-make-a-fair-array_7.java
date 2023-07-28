class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n = nums.length;
        int[] even = new int[n];
        int[] odd = new int[n];
        int sumEven = 0, sumOdd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sumEven += nums[i];
            } else {
                sumOdd += nums[i];
            }
            even[i] = sumEven;
            odd[i] = sumOdd;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftEven = 0, leftOdd = 0;
            if (i - 1 >= 0) {
                leftEven = even[i - 1];
                leftOdd = odd[i - 1];
            }
            int rightEven = sumEven - even[i];
            int rightOdd = sumOdd - odd[i];
            if (leftEven + rightOdd == leftOdd + rightEven) {
                res++;
            }
        }
        return res;
    }
}