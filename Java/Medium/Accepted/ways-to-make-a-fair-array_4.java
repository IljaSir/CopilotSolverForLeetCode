class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[i] = nums[i] + sumEven;
                sumEven = even[i];
                odd[i] = sumOdd;
            } else {
                odd[i] = nums[i] + sumOdd;
                sumOdd = odd[i];
                even[i] = sumEven;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftOdd = i - 1 >= 0 ? odd[i - 1] : 0;
            int leftEven = i - 1 >= 0 ? even[i - 1] : 0;
            int rightOdd = i + 1 < n ? odd[n - 1] - odd[i] : 0;
            int rightEven = i + 1 < n ? even[n - 1] - even[i] : 0;
            if (leftOdd + rightEven == leftEven + rightOdd) {
                res++;
            }
        }
        return res;
    }
}