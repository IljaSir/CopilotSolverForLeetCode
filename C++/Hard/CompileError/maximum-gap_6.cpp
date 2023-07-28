class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        if (nums.size() < 2) return 0;
        int min = *min_element(nums.begin(), nums.end());
        int max = *max_element(nums.begin(), nums.end());
        int bucketSize = (max - min) / (nums.size() - 1);
        if (bucketSize == 0) bucketSize = 1;
        int bucketNum = (max - min) / bucketSize + 1;
        vector<int> minBucket(bucketNum, INT_MAX);
        vector<int> maxBucket(bucketNum, INT_MIN);
        for (int i = 0; i < nums.size(); i++) {
            int index = (nums[i] - min) / bucketSize;
            minBucket[index] = min(minBucket[index], nums[i]);
            maxBucket[index] = max(maxBucket[index], nums[i]);
        }
        int maxGap = 0;
        int preMax = min;
        for (int i = 0; i < bucketNum; i++) {
            if (minBucket[i] == INT_MAX && maxBucket[i] == INT_MIN) continue;
            maxGap = max(maxGap, minBucket[i] - preMax);
            preMax = maxBucket[i];
        }
        return maxGap;
    }
};