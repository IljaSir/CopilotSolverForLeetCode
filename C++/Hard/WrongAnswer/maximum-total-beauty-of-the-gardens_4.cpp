class Solution {
public:
    long long maximumBeauty(vector<int>& flowers, long long newFlowers, int target, int full, int partial) {
        
        int n = flowers.size();
        sort(flowers.begin(), flowers.end());
        long long res = 0, cur = 0, minVal = 0;
        for (int i = 0; i < n; i++) {
            if (flowers[i] >= target) {
                cur++;
                res += full;
                newFlowers += flowers[i] - target;
            } else {
                minVal = flowers[i];
            }
        }
        if (cur == n) return res;
        long long minCnt = 0;
        for (int i = 0; i < n; i++) {
            if (flowers[i] == minVal) minCnt++;
        }
        long long remain = target - minVal;
        long long maxCnt = min(newFlowers / remain, (long long)n - cur);
        for (long long cnt = 0; cnt <= maxCnt; cnt++) {
            long long tmp = res + cnt * full + minCnt * partial;
            if (cnt < maxCnt) {
                tmp += (maxCnt - cnt) * remain * partial;
            }
            res = max(res, tmp);
        }
        return res;
    }
};