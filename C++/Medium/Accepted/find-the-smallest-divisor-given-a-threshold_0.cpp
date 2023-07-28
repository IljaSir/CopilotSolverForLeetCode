class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        
        int left = 1, right = 1e6;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
};