class Solution {
public:
    bool stoneGameIX(vector<int>& stones) {
        
        int cnt[3] = {0};
        for (auto s : stones) cnt[s % 3] ++;
        return (cnt[1] && cnt[2]) || (cnt[0] > 1 && (cnt[1] || cnt[2]));
    }
};