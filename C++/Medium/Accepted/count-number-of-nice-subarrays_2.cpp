class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> odd;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) odd.push_back(i);
        }
        int m = odd.size();
        if (m < k) return 0;
        int ans = 0;
        for (int i = 0; i <= m - k; i++) {
            int left = i == 0 ? odd[i] + 1 : odd[i] - odd[i - 1];
            int right = i == m - k ? n - odd[i + k - 1] : odd[i + k] - odd[i + k - 1];
            ans += left * right;
        }
        return ans;
    }
};