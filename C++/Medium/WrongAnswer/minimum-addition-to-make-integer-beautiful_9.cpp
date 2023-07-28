class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long ans = 0;
        int cnt[10] = {0};
        while (n) {
            cnt[n%10]++;
            n /= 10;
        }
        int sum = 0;
        for (int i = 0; i < 10; ++i) {
            sum += cnt[i]*i;
        }
        if (sum > target) {
            for (int i = 0; i < 10; ++i) {
                if (sum <= target) break;
                if (cnt[i] == 0) continue;
                int x = min(cnt[i], sum-target);
                ans += x*i;
                sum -= x;
            }
        }
        return ans;
    }
};