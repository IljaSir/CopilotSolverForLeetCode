class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, 0);
        for (int i = 0; i < n; i++) {
            int j = i;
            int max_bitwise_or = nums[i];
            while (j + 1 < n && (max_bitwise_or | nums[j + 1]) > max_bitwise_or) {
                max_bitwise_or |= nums[++j];
            }
            ans[i] = j - i + 1;
        }
        return ans;
    }
};