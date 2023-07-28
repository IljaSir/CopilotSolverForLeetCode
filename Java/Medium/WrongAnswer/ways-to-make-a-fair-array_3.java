class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        int oddSum = 0;
        int evenSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                evenSum += nums[i];
                even[i] = evenSum;
                odd[i] = oddSum;
            } else {
                oddSum += nums[i];
                odd[i] = oddSum;
                even[i] = evenSum;
            }
        }
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            int oddSum1 = 0;
            int evenSum1 = 0;
            if(i > 0) {
                oddSum1 = odd[i - 1];
                evenSum1 = even[i - 1];
            }
            int oddSum2 = odd[odd.length - 1] - odd[i];
            int evenSum2 = even[even.length - 1] - even[i];
            if(oddSum1 + oddSum2 == evenSum1 + evenSum2) {
                result++;
            }
        }
        return result;
    }
}