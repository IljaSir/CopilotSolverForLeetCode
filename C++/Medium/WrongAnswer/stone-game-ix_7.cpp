class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int n = stones.size(), sum = 0;
        vector<int> cnt(3);
        for (auto x : stones) {
            sum += x;
            cnt[x % 3]++;
        }
        if (sum % 3 == 0) {
            if (cnt[0] == 0) return false;
            if (cnt[1] == 0 || cnt[2] == 0) return true;
            return cnt[1] % 2 == 0 || cnt[2] % 2 == 0;
        }
        if (sum % 3 == 1) {
            return cnt[1] > 0 && cnt[2] > 0;
        }
        return cnt[1] > 0 && cnt[2] > 0;
    }
};