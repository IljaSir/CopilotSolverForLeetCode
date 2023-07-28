class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long n = 5;
        long long cnt = 0;
        while (n <= (long long)1e10) {
            long long t = n;
            while (t % 5 == 0) {
                cnt++;
                t /= 5;
            }
            if (cnt == k) {
                return 5;
            }
            n += 5;
        }
        return 0;
    }
};