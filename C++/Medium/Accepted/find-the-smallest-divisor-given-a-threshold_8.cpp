class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        
        int l = 1, r = 1e6;
        while (l < r) {
            int mid = (l + r) >> 1;
            int sum = 0;
            for (auto num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum > threshold) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};