class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        map<int, int> m;
        for (int i = 0; i < barcodes.size(); i++) {
            m[barcodes[i]]++;
        }
        vector<pair<int, int>> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            v.push_back(make_pair(it->second, it->first));
        }
        sort(v.begin(), v.end());
        int i = 0;
        int j = 0;
        while (i < barcodes.size()) {
            while (j < v.size() && v[j].first == 0) {
                j++;
            }
            if (j >= v.size()) {
                break;
            }
            barcodes[i] = v[j].second;
            v[j].first--;
            i += 2;
        }
        i = 1;
        while (i < barcodes.size()) {
            while (j < v.size() && v[j].first == 0) {
                j++;
            }
            if (j >= v.size()) {
                break;
            }
            barcodes[i] = v[j].second;
            v[j].first--;
            i += 2;
        }
        return barcodes;
    }
};