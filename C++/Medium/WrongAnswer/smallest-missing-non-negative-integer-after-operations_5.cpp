class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int l = 0, r = n - 1;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] - res * value <= 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            res++;
        }
        return res;
    }
    int minOperations(vector<int>& nums, int x) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int target = sum - x;
        if (target == 0) return n;
        int res = -1;
        int l = 0, r = 0;
        int cur = 0;
        while (r < n) {
            while (r < n && cur < target) {
                cur += nums[r++];
            }
            if (cur == target) {
                res = max(res, r - l);
            }
            while (l < r && cur >= target) {
                cur -= nums[l++];
            }
            if (cur == target) {
                res = max(res, r - l);
            }
        }
        return res == -1 ? -1 : n - res;
    }
    int minOperations2(vector<int>& nums, int x) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int target = sum - x;
        if (target == 0) return n;
        int res = -1;
        int l = 0, r = 0;
        int cur = 0;
        while (r < n) {
            while (r < n && cur < target) {
                cur += nums[r++];
            }
            if (cur == target) {
                res = max(res, r - l);
            }
            while (l < r && cur >= target) {
                cur -= nums[l++];
            }
            if (cur == target) {
                res = max(res, r - l);
            }
        }
        return res == -1 ? -1 : n - res;
    }
};