class Solution {
public:
    vector<int> rearrangeBarcodes(vector<int>& barcodes) {
        
        int n = barcodes.size();
        vector<int> res(n);
        unordered_map<int, int> freq;
        for (int i = 0; i < n; i++) {
            freq[barcodes[i]]++;
        }
        vector<pair<int, int>> freqs;
        for (auto it = freq.begin(); it != freq.end(); it++) {
            freqs.push_back({it->second, it->first});
        }
        sort(freqs.begin(), freqs.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first > b.first;
        });
        int i = 0;
        for (auto f : freqs) {
            int cnt = f.first;
            int val = f.second;
            while (cnt--) {
                res[i] = val;
                i += 2;
                if (i >= n) {
                    i = 1;
                }
            }
        }
        return res;
    }
};