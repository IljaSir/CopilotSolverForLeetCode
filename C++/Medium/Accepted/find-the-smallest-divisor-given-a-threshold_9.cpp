class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        
        const int MIN = 1;
        const int MAX = 1000000;
        int left = MIN;
        int right = MAX;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};