class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> maxp(n), maxn(n), minp(n), minn(n);
        for(int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                maxp[i] = i > 0 ? maxp[i-1] + 1 : 1;
                maxn[i] = i > 0 ? maxn[i-1] + 1 : 0;
                minp[i] = i > 0 ? minp[i-1] + 1 : 0;
                minn[i] = i > 0 ? minn[i-1] + 1 : 0;
            } else if (nums[i] < 0) {
                maxp[i] = i > 0 ? maxn[i-1] + 1 : 0;
                maxn[i] = i > 0 ? maxp[i-1] + 1 : 1;
                minp[i] = i > 0 ? minn[i-1] + 1 : 0;
                minn[i] = i > 0 ? minp[i-1] + 1 : 1;
            } else {
                maxp[i] = 0; maxn[i] = 0; minp[i] = 0; minn[i] = 0;
            }
        }
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            ans = max(ans, maxp[i]);
        }
        return ans;
    }
};