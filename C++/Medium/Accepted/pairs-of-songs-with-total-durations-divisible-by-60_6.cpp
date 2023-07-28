class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int n = time.size();
        int res = 0;
        int cnt[60] = {0};
        for (int i = 0; i < n; i++) {
            int t = time[i] % 60;
            res += cnt[(60 - t) % 60];
            cnt[t] ++;
        }
        return res;
    }
};