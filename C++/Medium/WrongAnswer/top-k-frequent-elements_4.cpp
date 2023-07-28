class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        unordered_map<int, int> freq;
        for (int n : nums) {
            freq[n]++;
        }
        priority_queue<pair<int, int>> pq;
        for (auto& [n, f] : freq) {
            pq.emplace(f, n);
            if (pq.size() > k) pq.pop();
        }
        vector<int> res;
        while (!pq.empty()) {
            res.push_back(pq.top().second);
            pq.pop();
        }
        return res;
    }
};