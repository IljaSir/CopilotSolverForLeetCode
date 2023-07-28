class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        unordered_map<string, int> freq;
        for (auto& w : words) {
            ++freq[w];
        }
        priority_queue<pair<int, string>> pq;
        for (auto& [w, f] : freq) {
            pq.push({f, w});
            if (pq.size() > k) {
                pq.pop();
            }
        }
        vector<string> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};