class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        unordered_map<int, int> m;
        for (int b: barcodes) m[b]++;
        vector<pair<int, int>> v;
        for (auto p: m) v.push_back(p);
        sort(v.begin(), v.end(), [](pair<int, int> p1, pair<int, int> p2) {return p1.second > p2.second;});
        vector<int> res(barcodes.size());
        int i = 0;
        for (auto p: v) {
            for (int j = 0; j < p.second; j++) {
                res[i] = p.first;
                i += 2;
                if (i >= res.size()) i = 1;
            }
        }
        return res;
    }
};