class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) return 0;
        int minVal = *min_element(nums.begin(), nums.end());
        int maxVal = *max_element(nums.begin(), nums.end());
        int d = max(1, (maxVal - minVal) / (n - 1));
        int bucketSize = (maxVal - minVal) / d + 1;
        vector<vector<int>> buckets(bucketSize);
        for (int num : nums) {
            int idx = (num - minVal) / d;
            if (buckets[idx].empty()) {
                buckets[idx].push_back(num);
                buckets[idx].push_back(num);
            } else {
                buckets[idx][0] = min(buckets[idx][0], num);
                buckets[idx][1] = max(buckets[idx][1], num);
            }
        }
        int ret = 0, prev = 0;
        for (int i = 1; i < bucketSize; i++) {
            if (buckets[i].empty()) continue;
            ret = max(ret, buckets[i][0] - buckets[prev][1]);
            prev = i;
        }
        return ret;
    }
};