class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        
        int cnt[2051] = {0};
        for (auto& log : logs) {
            cnt[log[0]]++;
            cnt[log[1]]--;
        }
        int maxCnt = cnt[1950];
        int res = 1950;
        for (int i = 1951; i <= 2050; i++) {
            cnt[i] += cnt[i - 1];
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                res = i;
            }
        }
        return res;
    }
};