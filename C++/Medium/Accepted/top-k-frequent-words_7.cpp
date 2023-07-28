class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        map<string, int> freq;
        for (auto& word: words) {
            freq[word]++;
        }
        vector<pair<string, int>> v;
        for (auto& p: freq) {
            v.push_back(p);
        }
        sort(v.begin(), v.end(), [](auto& p1, auto& p2) {
            return p1.second > p2.second || (p1.second == p2.second && p1.first < p2.first);
        });
        vector<string> ans;
        for (int i = 0; i < k; ++i) {
            ans.push_back(v[i].first);
        }
        return ans;
    }
};