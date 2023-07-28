class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        unordered_map<string, int> freq;
        for (auto &word: words) {
            freq[word]++;
        }
        vector<pair<string, int>> v;
        for (auto &f: freq) {
            v.push_back(make_pair(f.first, f.second));
        }
        sort(v.begin(), v.end(), [](pair<string, int> &a, pair<string, int> &b) {
            if (a.second == b.second) {
                return a.first < b.first;
            }
            return a.second > b.second;
        });
        vector<string> ans;
        for (int i = 0; i < k; i++) {
            ans.push_back(v[i].first);
        }
        return ans;
    }
};