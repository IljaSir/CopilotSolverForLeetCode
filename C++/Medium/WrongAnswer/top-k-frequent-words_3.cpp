class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        unordered_map<string, int> freq;
        for (auto w : words) {
            ++freq[w];
        }
        auto cmp = [](const pair<string, int>& a, const pair<string, int>& b) {
            return a.second < b.second || (a.second == b.second && a.first > b.first);
        };
        priority_queue<pair<string, int>, vector<pair<string, int>>, decltype(cmp)> pq(cmp);
        for (auto [w, f] : freq) {
            pq.push({w, f});
            if (pq.size() > k) {
                pq.pop();
            }
        }
        vector<string> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};