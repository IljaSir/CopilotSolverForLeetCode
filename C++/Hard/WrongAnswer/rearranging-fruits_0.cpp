class Solution {
public:
    long long minCost(vector<int>& basket1, vector<int>& basket2) {
        
        long long sum1 = 0, sum2 = 0;
        for (int i = 0; i < basket1.size(); i++) {
            sum1 += basket1[i];
            sum2 += basket2[i];
        }
        if (sum1 > sum2) {
            swap(basket1, basket2);
            swap(sum1, sum2);
        }
        long long res = sum1;
        vector<int> cnt1(100001, 0), cnt2(100001, 0);
        for (int i = 0; i < basket1.size(); i++) {
            cnt1[basket1[i]]++;
            cnt2[basket2[i]]++;
        }
        for (int i = 0; i < 100001; i++) {
            if (cnt1[i] == 0) continue;
            int j = (i + 1) / 2;
            if (cnt2[j] == 0) continue;
            int minCnt = min(cnt1[i], cnt2[j]);
            sum1 -= minCnt * i;
            sum2 -= minCnt * j;
            res = min(res, sum1 + sum2);
        }
        return res;
    }
};