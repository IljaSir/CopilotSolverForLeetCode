class Solution {
public:
    int waysToPartition(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> pre(n+1,0);
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        int res = 0;
        int sum = pre[n];
        for (int i = 0; i < n; i++) {
            if (pre[i] == sum - pre[i]) res++;
        }
        int mx = res;
        for (int i = 0; i < n; i++) {
            int x = pre[i] + k;
            int y = sum - pre[i] - k;
            if (x == y) {
                mx = max(mx, res + 1);
            }
        }
        return mx;
    }
};