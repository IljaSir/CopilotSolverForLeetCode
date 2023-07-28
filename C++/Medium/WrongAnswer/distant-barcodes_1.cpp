class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < barcodes.size(); i++) {
            m[barcodes[i]]++;
        }
        vector<pair<int, int>> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            v.push_back(make_pair(it->first, it->second));
        }
        sort(v.begin(), v.end(), [](pair<int, int> a, pair<int, int> b) { return a.second > b.second; });
        vector<int> res;
        int i = 0;
        while (i < barcodes.size()) {
            for (int j = 0; j < v.size(); j++) {
                if (v[j].second == 0) continue;
                res.push_back(v[j].first);
                v[j].second--;
                i++;
            }
        }
        return res;
    }
};