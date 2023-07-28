class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int k = 0;
        for (int i = 0; i < n; i += 2) {
            k += nums[i + 1] - nums[i];
        }
        k /= n / 2;
        vector<int> ans;
        for (int i = 0; i < n; i += 2) {
            ans.push_back(nums[i] + k);
        }
        return ans;
    }
};