class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        if (nums.size() < 2) return 0;
        int min_value = *min_element(nums.begin(), nums.end());
        int max_value = *max_element(nums.begin(), nums.end());
        int bucket_size = max(1, (max_value - min_value) / (int)(nums.size() - 1));
        int bucket_num = (max_value - min_value) / bucket_size + 1;
        vector<pair<int, int>> buckets(bucket_num, {-1, -1});
        for (int& num : nums) {
            int idx = (num - min_value) / bucket_size;
            if (buckets[idx].first == -1) {
                buckets[idx].first = num;
                buckets[idx].second = num;
            } else {
                buckets[idx].first = min(buckets[idx].first, num);
                buckets[idx].second = max(buckets[idx].second, num);
            }
        }
        int prev = -1;
        int max_gap = 0;
        for (int i = 0; i < bucket_num; i++) {
            if (buckets[i].first == -1) continue;
            if (prev != -1) {
                max_gap = max(max_gap, buckets[i].first - buckets[prev].second);
            }
            prev = i;
        }
        return max_gap;
    }
};