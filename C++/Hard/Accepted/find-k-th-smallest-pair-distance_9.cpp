class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int low = 0, high = nums[n-1] - nums[0];
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < n; ++i) {
                count += upper_bound(nums.begin(), nums.end(), nums[i] + mid) - nums.begin() - i - 1;
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
};