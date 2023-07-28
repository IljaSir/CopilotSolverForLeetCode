class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
                even[i] = evenSum;
                odd[i] = oddSum;
            } else {
                oddSum += nums[i];
                odd[i] = oddSum;
                even[i] = evenSum;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int leftOdd = i == 0 ? 0 : odd[i - 1];
            int leftEven = i == 0 ? 0 : even[i - 1];
            int rightOdd = i == n - 1 ? 0 : odd[n - 1] - odd[i];
            int rightEven = i == n - 1 ? 0 : even[n - 1] - even[i];
            if (leftOdd + rightEven == leftEven + rightOdd) {
                cnt++;
            }
        }
        return cnt;
    }
}