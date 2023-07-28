class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int left = 0, right = nums.back() - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, start = 0;
            for (int end = 0; end < nums.size(); ++end) {
                while (nums[end] - nums[start] > mid) {
                    ++start;
                }
                count += end - start;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
};