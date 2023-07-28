class Solution {
public:
    long long kMirror(int k, int n) {
        
        long long res = 0;
        for (int i = 1; i <= n; i++) {
            long long num = 0;
            int cnt = 0;
            while (cnt < i) {
                num = num * k + 1;
                cnt++;
            }
            res += num;
        }
        return res;
    }
};