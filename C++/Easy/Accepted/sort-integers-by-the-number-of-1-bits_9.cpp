class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        vector<int> res;
        vector<vector<int>> v(15);
        for (int i: arr) {
            int cnt = 0;
            int j = i;
            while (j != 0) {
                if (j & 1) cnt++;
                j >>= 1;
            }
            v[cnt].push_back(i);
        }
        for (int i = 0; i < 15; i++) {
            sort(v[i].begin(), v[i].end());
            for (int j: v[i]) res.push_back(j);
        }
        return res;
    }
};