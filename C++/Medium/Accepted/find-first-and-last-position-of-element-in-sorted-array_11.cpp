class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int n = nums.size();
        int l = 0, r = n-1;
        vector<int> ans = {-1,-1};
        if (n == 0) return ans;
        while (l < r) {
            int m = l + (r-l)/2;
            if (nums[m] < target) l = m+1;
            else r = m;
        }
        if (nums[l] != target) return ans;
        ans[0] = l;
        r = n-1;
        while (l < r) {
            int m = l + (r-l)/2 + 1;
            if (nums[m] > target) r = m-1;
            else l = m;
        }
        ans[1] = r;
        return ans;
    }
};