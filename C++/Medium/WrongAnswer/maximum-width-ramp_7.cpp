class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> idx(n, 0);
        iota(idx.begin(), idx.end(), 0);
        sort(idx.begin(), idx.end(), [&nums](int i, int j) {
            return nums[i] < nums[j];
        });
        int m = n;
        for (int i = 0; i < n; i++) {
            ans = max(ans, idx[i] - m);
            m = min(m, idx[i]);
        }
        return ans;
    }
};