class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        int n = barcodes.size();
        vector<int> res(n);
        unordered_map<int, int> m;
        for (auto b: barcodes) {
            m[b]++;
        }
        vector<pair<int, int>> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            v.push_back(make_pair(it->second, it->first));
        }
        sort(v.begin(), v.end(), [](pair<int, int> a, pair<int, int> b) {
            return a.first > b.first;
        });
        int i = 0;
        for (auto p: v) {
            while (p.first--) {
                res[i] = p.second;
                i += 2;
                if (i >= n) i = 1;
            }
        }
        return res;
    }
};