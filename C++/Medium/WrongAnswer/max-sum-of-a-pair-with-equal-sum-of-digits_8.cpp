class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int maxSum = -1;
        int sum = 0;
        int maxDigit = 0;
        int minDigit = 9;
        int maxIndex = -1;
        int minIndex = -1;
        int maxIndex2 = -1;
        int minIndex2 = -1;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum > maxDigit) {
                maxDigit = sum;
                maxIndex2 = maxIndex;
                maxIndex = i;
            } else if (sum == maxDigit) {
                if (maxIndex2 == -1) {
                    maxIndex2 = i;
                } else if (nums[i] > nums[maxIndex2]) {
                    maxIndex2 = i;
                }
            }
            if (sum < minDigit) {
                minDigit = sum;
                minIndex2 = minIndex;
                minIndex = i;
            } else if (sum == minDigit) {
                if (minIndex2 == -1) {
                    minIndex2 = i;
                } else if (nums[i] > nums[minIndex2]) {
                    minIndex2 = i;
                }
            }
        }
        if (maxDigit == minDigit) {
            if (maxIndex == minIndex) {
                if (maxIndex2 != -1 && minIndex2 != -1) {
                    maxSum = max(nums[maxIndex] + nums[maxIndex2], nums[minIndex] + nums[minIndex2]);
                } else {
                    maxSum = -1;
                }
            } else {
                maxSum = nums[maxIndex] + nums[minIndex];
            }
        } else {
            maxSum = nums[maxIndex] + nums[maxIndex2];
        }
        return maxSum;
    }
};