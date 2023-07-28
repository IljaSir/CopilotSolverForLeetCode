class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        int n = nums.size();
        int l = 0, r = n-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (check(nums, m, k)) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return l-1;
    }
    
    bool check(vector<int>& nums, int m, int k) {
        int n = nums.size();
        int cnt = 0;
        for (int i = n-1; i >= m; --i) {
            cnt += nums[i];
        }
        return cnt <= k;
    }
};