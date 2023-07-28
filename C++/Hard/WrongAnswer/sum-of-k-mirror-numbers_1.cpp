class Solution {
public:
    long long kMirror(int k, int n) {
        
        vector<long long> res;
        for (int i = 1; i < k; ++i) {
            res.push_back(i);
        }
        while (res.size() < n) {
            int sz = res.size();
            for (int i = sz - 1; i >= 0; --i) {
                long long x = res[i];
                long long y = x;
                int cnt = 0;
                while (y > 0) {
                    cnt++;
                    y /= k;
                }
                y = x;
                while (cnt > 0) {
                    y = y * k + y % k;
                    cnt--;
                }
                res.push_back(y);
                if (res.size() == n) {
                    break;
                }
            }
        }
        long long sum = 0;
        for (long long x : res) {
            sum += x;
        }
        return sum;
    }
};