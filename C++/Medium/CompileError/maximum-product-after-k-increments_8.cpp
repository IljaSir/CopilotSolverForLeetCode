class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        // sort the array
        sort(nums.begin(), nums.end());
        // find the min number
        int min = nums[0];
        // find the max number
        int max = nums[nums.size() - 1];
        // find the second max number
        int secondMax = nums[nums.size() - 2];
        // find the second min number
        int secondMin = nums[1];
        // find the number of min numbers
        int minCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == min) {
                minCount++;
            }
        }
        // find the number of max numbers
        int maxCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == max) {
                maxCount++;
            }
        }
        // if k is even
        if (k % 2 == 0) {
            // if k is less than the number of min numbers
            if (k <= minCount) {
                // find the number of min numbers after k operations
                int minCountAfter = minCount / k;
                // find the number of max numbers after k operations
                int maxCountAfter = maxCount / k;
                // find the number of second max numbers after k operations
                int secondMaxCountAfter = (nums.size() - minCount - maxCount) / k;
                // find the number of second min numbers after k operations
                int secondMinCountAfter = (nums.size() - minCount - maxCount) / k;
                // return the product of min numbers, max numbers, second max numbers, second min numbers
                return (int)pow(min, k) * (int)pow(max, k) * (int)pow(secondMax, secondMaxCountAfter) * (int)pow(secondMin, secondMinCountAfter);
            }
            // if k is less than the number of max numbers
            if (k <= maxCount) {
                // find the number of min numbers after k operations
                int minCountAfter = minCount / k;
                // find the number of max numbers after k operations
                int maxCountAfter = maxCount / k;
                // find the number of second max numbers after k operations
                int secondMax
    }
};