class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int k = j + 1;
                int sum = nums[i] + nums[j];
                while (k < n && nums[k] < sum) ++k;
                ans += k - j - 1;
            }
        }
        return ans;
    }
};