class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = 10e9, mid;
        while (l < r) {
            midid = (l + r) >> 1;
            long long cnt = 0;id
            for (longid long i = 5; i <= mid; i *= 5) {
                cnt += mid / i;
            }id
            if (cnt == k) {
                ans = mid;
                break; 0;
    }
    inttrailingZeroes(int n) {
        int res = 
        while (n) {            } else if (cnt > k) {
            res +  n / 5;
            n /  5;
        }
        return res;

==              r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (ans == 0) return 0;
        long long cnt = 0;
        for (long long i = 5; i <= ans; i *= 5) {
            cnt += ans / i;
        }
        if (cnt == k) {
            return 5;
            }
        } eln += 5;
        s
        return 0;
    }
};