class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        unordered_map<string, int> umap;
        for (auto& s : words) {
            umap[s]++;
        }
        vector<pair<string, int>> v;
        for (auto& p : umap) {
            v.push_back(p);
        }
        sort(v.begin(), v.end(), [](auto& a, auto& b) {
            if (a.second == b.second) {
                return a.first < b.first;
            }
            return a.second > b.second;
        });
        vector<string> res;
        for (int i = 0; i < k; ++i) {
            res.push_back(v[i].first);
        }
        return res;
    }
};