class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        int n = nums.size();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i != nums[j] - nums[i]) {
                    result++;
                }
            }
        }
        return result;
    }
};