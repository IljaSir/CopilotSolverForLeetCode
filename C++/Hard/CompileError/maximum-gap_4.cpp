class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        if (nums.size() < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int bucketSize = max(nums.size(), (max - min) / (nums.size() - 1));
        int bucketNum = (max - min) / bucketSize + 1;
        vector<int> bucketMin(bucketNum, INT_MAX);
        vector<int> bucketMax(bucketNum, INT_MIN);
        for (int i = 0; i < nums.size(); i++) {
            int bucketIndex = (nums[i] - min) / bucketSize;
            if (nums[i] < bucketMin[bucketIndex]) {
                bucketMin[bucketIndex] = nums[i];
            }
            if (nums[i] > bucketMax[bucketIndex]) {
                bucketMax[bucketIndex] = nums[i];
            }
        }
        int maxGap = 0;
        int prevMax = bucketMax[0];
        for (int i = 1; i < bucketNum; i++) {
            if (bucketMin[i] == INT_MAX) {
                continue;
            }
            maxGap = max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        return maxGap;
    }
};