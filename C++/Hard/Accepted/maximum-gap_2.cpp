class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) return 0;
        int minNum = *min_element(nums.begin(), nums.end());
        int maxNum = *max_element(nums.begin(), nums.end());
        int d = max(1, (maxNum - minNum) / (n - 1));
        int bucketSize = (maxNum - minNum) / d + 1;
        vector<vector<int>> buckets(bucketSize);
        for (int i = 0; i < n; ++i) {
            int idx = (nums[i] - minNum) / d;
            if (buckets[idx].empty()) {
                buckets[idx].push_back(nums[i]);
                buckets[idx].push_back(nums[i]);
            } else {
                buckets[idx][0] = min(buckets[idx][0], nums[i]);
                buckets[idx][1] = max(buckets[idx][1], nums[i]);
            }
        }
        int ret = 0, prev = -1;
        for (int i = 0; i < bucketSize; ++i) {
            if (buckets[i].empty()) continue;
            if (prev != -1) {
                ret = max(ret, buckets[i][0] - buckets[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
};