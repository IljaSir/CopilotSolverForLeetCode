class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        if (nums.size() < 2) {
            return 0;
        }
        int maxVal = *max_element(nums.begin(), nums.end());
        int minVal = *min_element(nums.begin(), nums.end());
        int d = max(1, (maxVal - minVal) / ((int)nums.size() - 1));
        int bucketSize = (maxVal - minVal) / d + 1;
        vector<vector<int>> bucket(bucketSize, vector<int>());
        for (int i = 0; i < nums.size(); i++) {
            int idx = (nums[i] - minVal) / d;
            if (bucket[idx].empty()) {
                bucket[idx].push_back(nums[i]);
                bucket[idx].push_back(nums[i]);
            } else {
                bucket[idx][0] = min(bucket[idx][0], nums[i]);
                bucket[idx][1] = max(bucket[idx][1], nums[i]);
            }
        }
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket[i].empty()) {
                continue;
            }
            if (prev != -1) {
                ret = max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
};