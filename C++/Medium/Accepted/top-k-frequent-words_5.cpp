class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        unordered_map<string, int> freq;
        for (string& w : words) {
            freq[w]++;
        }
        vector<pair<string, int>> v;
        for (auto& p : freq) {
            v.push_back(p);
        }
        sort(v.begin(), v.end(), [](const pair<string, int>& p1, const pair<string, int>& p2) {
            if (p1.second == p2.second) {
                return p1.first < p2.first;
            }
            return p1.second > p2.second;
        });
        vector<string> ans;
        for (int i = 0; i < k; i++) {
            ans.push_back(v[i].first);
        }
        return ans;
    }
};