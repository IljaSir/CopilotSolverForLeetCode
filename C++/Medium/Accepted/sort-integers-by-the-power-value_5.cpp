class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int, int>> v;
        for (int i = lo; i <= hi; ++i) {
            int cnt = 0;
            for (int j = i; j > 1; ++cnt) {
                if (j & 1) j = 3 * j + 1;
                else j /= 2;
            }
            v.push_back({cnt, i});
        }
        sort(v.begin(), v.end());
        return v[k - 1].second;
    }
};