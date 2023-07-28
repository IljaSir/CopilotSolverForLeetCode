class Solution {
public:
    int minMoves(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> ones;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones.push_back(i);
            }
        }
        int m = ones.size();
        vector<int> prefix_sum(m+1, 0);
        for (int i = 1; i <= m; i++) {
            prefix_sum[i] = prefix_sum[i-1] + ones[i-1];
        }
        int ans = INT_MAX;
        for (int i = 0; i + k - 1 < m; i++) {
            int mid = i + k / 2;
            int left = ones[mid] * k - (prefix_sum[mid+1] - prefix_sum[i]);
            int right = (prefix_sum[i+k] - prefix_sum[mid+1]) - ones[mid] * k;
            ans = min(ans, left + right);
        }
        return ans;
    }
};