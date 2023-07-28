class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int cnt[3] = {0};
        for (int s : stones) {
            cnt[s % 3]++;
        }
        if (cnt[0] % 2 == 1) {
            return cnt[1] > 0 && cnt[2] > 0;
        } else {
            return abs(cnt[1] - cnt[2]) >= 3;
        }
    }
};