class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int l = 0, r = nums[n-1] - nums[0];
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < n; ++right) {
                while (nums[right] - nums[left] > mid) {
                    ++left;
                }
                count += right - left;
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};