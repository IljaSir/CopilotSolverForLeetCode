class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        unordered_map<int, int> m;
        for (auto n : nums) {
            ++m[n];
        }
        priority_queue<pair<int, int>> pq;
        for (auto& [n, c] : m) {
            pq.push({c, n});
        }
        vector<int> res(k);
        for (int i = 0; i < k; ++i) {
            res[i] = pq.top().second;
            pq.pop();
        }
        return res;
    }
};