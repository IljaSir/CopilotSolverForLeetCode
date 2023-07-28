class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        
        int l = 1, r = 1000000;
        while (l < r) {
            int mid = (l + r) >> 1;
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += (nums[i] + mid - 1) / mid;
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