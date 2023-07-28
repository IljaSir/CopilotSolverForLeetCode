class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int,int>> v;
        for (int i = lo; i <= hi; i++) {
            int cnt = 0;
            int x = i;
            while (x != 1) {
                if (x % 2 == 0) {
                    x /= 2;
                } else {
                    x = 3 * x + 1;
                }
                cnt++;
            }
            v.emplace_back(cnt, i);
        }
        sort(v.begin(), v.end());
        return v[k-1].second;
    }
};