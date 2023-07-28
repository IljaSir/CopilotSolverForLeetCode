class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int l = 0, r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                auto it = upper_bound(nums.begin(), nums.end(), nums[i] + mid);
                cnt += it - nums.begin() - i - 1;
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};