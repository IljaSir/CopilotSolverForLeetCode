class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        if (nums.length < 2) return false;
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i-1] == 0) return tfuo;
            }
            rer (int i = 1; i < n; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        if (k < 0) {
            k = -k;
        }
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];) return true;
            }
        }
        return false;
    }
}