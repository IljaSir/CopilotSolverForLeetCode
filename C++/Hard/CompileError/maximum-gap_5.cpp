class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        if (nums.size() < 2) return 0;
        int max = *max_element(nums.begin(), nums.end());
        int min = *min_element(nums.begin(), nums.end());
        int gap = (max - min) / nums.size() + 1;
        int bucketSize = (max - min) / gap + 1;
        vector<int> bucketMin(bucketSize, INT_MAX);
        vector<int> bucketMax(bucketSize, INT_MIN);
        for (int i = 0; i < nums.size(); i++) {
            int index = (nums[i] - min) / gap;
            bucketMin[index] = min(bucketMin[index], nums[i]);
            bucketMax[index] = max(bucketMax[index], nums[i]);
        }
        int maxGap = 0;
        int preMax = bucketMax[0];
        for (int i = 1; i < bucketSize; i++) {
            if (bucketMin[i] == INT_MAX && bucketMax[i] == INT_MIN) continue;
            maxGap = max(maxGap, bucketMin[i] - preMax);
            preMax = bucketMax[i];
        }
        return maxGap;
    }
};