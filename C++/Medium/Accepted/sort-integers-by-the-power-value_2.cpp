class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int, int>> v;
        for (int i = lo; i <= hi; i++) {
            int count = 0;
            int n = i;
            while (n != 1) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = 3 * n + 1;
                }
                count++;
            }
            v.push_back({i, count});
        }
        sort(v.begin(), v.end(), [](pair<int, int> a, pair<int, int> b) {
            return a.second < b.second || (a.second == b.second && a.first < b.first);
        });
        return v[k - 1].first;
    }
};