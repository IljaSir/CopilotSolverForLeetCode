class Solution {
public:
    int maximumWhiteTiles(vector<vector<int>>& tiles, int carpetLen) {
        
        int n = tiles.size();
        vector<int> ends;
        for (auto &tile : tiles) {
            ends.push_back(tile[0]);
            ends.push_back(tile[1] + 1);
        }
        sort(ends.begin(), ends.end());
        ends.resize(unique(ends.begin(), ends.end()) - ends.begin());
        int m = ends.size();
        vector<int> sum(m + 1);
        for (auto &tile : tiles) {
            int l = lower_bound(ends.begin(), ends.end(), tile[0]) - ends.begin();
            int r = lower_bound(ends.begin(), ends.end(), tile[1] + 1) - ends.begin();
            sum[l]++;
            sum[r]--;
        }
        for (int i = 1; i < m; ++i) {
            sum[i] += sum[i - 1];
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            if (sum[i] > 0) {
                int l = ends[i];
                int r = ends[i] + carpetLen - 1;
                int j = lower_bound(ends.begin(), ends.end(), r + 1) - ends.begin() - 1;
                res += sum[i] * (ends[j] - l);
                i = j - 1;
            }
        }
        return res;
    }
};