class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }
};