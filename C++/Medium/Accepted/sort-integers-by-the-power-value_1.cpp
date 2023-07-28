class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int, int>> v;
        for (int i = lo; i <= hi; ++i) {
            int j = i;
            int cnt = 0;
            while (j != 1) {
                if (j & 1) {
                    j = 3 * j + 1;
                } else {
                    j >>= 1;
                }
                ++cnt;
            }
            v.push_back(make_pair(cnt, i));
        }
        sort(v.begin(), v.end());
        return v[k - 1].second;
    }
};