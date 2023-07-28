class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        int sum = 0;
        for (int i = 0; i < quantities.size(); ++i) {
            sum += quantities[i];
        }
        int l = 1, r = sum;
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < quantities.size(); ++i) {
                cnt += quantities[i] / mid;
                if (quantities[i] % mid) {
                    ++cnt;
                }
            }
            if (cnt <= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};