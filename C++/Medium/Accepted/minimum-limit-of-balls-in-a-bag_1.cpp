class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        
        int lo = 1, hi = *max_element(nums.begin(), nums.end());
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int operations = 0;
            for (int num : nums) {
                operations += (num - 1) / mid;
            }
            if (operations <= maxOperations) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
};