class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int sum = 0;
        int cnt[3] = {0};
        for (auto stone : stones) {
            sum += stone;
            cnt[stone % 3]++;
        }
        if (sum % 3 == 0) {
            return cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0;
        } else if (sum % 3 == 1) {
            return cnt[1] > 1 || (cnt[1] > 0 && cnt[2] > 0);
        } else {
            return cnt[2] > 1 || (cnt[1] > 0 && cnt[2] > 0);
        }
    }
};