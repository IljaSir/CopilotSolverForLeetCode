class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        unordered_map<int, int> freq;
        for (auto &n : nums) {
            freq[n]++;
        }
        vector<vector<int>> buckets(nums.size() + 1);
        for (auto &p : freq) {
            buckets[p.second].push_back(p.first);
        }
        vector<int> res;
        for (int i = buckets.size() - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i].size()) {
                res.insert(res.end(), buckets[i].begin(), buckets[i].end());
            }
        }
        return res;
    }
};