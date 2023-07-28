class Solution {
public:
    int destroyTargets(vector<int>& nums, int space) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int l = 0, r = n - 1;
        int ans = 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(nums, mid, space)) {
                l = mid;
                ans = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return nums[ans];
    }
    bool check(vector<int>& nums, int mid, int space) {
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            int j = i + mid;
            if (j >= n) {
                return false;
            }
            if ((nums[j] - nums[i]) % space != 0) {
                return false;
            }
        }
        return true;
    }
};