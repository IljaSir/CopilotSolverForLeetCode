class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int, int>> v;
        for (int i = lo; i <= hi; i++) {
            int cnt = 0, x = i;
            while (x != 1) {
                if (x & 1) {
                    x = 3 * x + 1;
                } else {
                    x >>= 1;
                }
                cnt++;
            }
            v.push_back(make_pair(cnt, i));
        }
        sort(v.begin(), v.end());
        return v[k - 1].second;
    }
};