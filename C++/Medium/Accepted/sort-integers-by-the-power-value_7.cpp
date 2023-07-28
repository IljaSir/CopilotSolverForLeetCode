class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        int n = hi - lo + 1;
        vector<pair<int, int>> v;
        for (int i = lo; i <= hi; i++) {
            int j = i;
            int cnt = 0;
            while (j != 1) {
                if (j % 2 == 0) {
                    j /= 2;
                } else {
                    j = 3 * j + 1;
                }
                cnt++;
            }
            v.push_back({cnt, i});
        }
        sort(v.begin(), v.end());
        return v[k - 1].second;
    }
};