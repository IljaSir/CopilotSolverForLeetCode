class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        
        int cnt[14] = {0}, suit[4] = {0};
        for(int i = 0; i < 5; ++i) {
            ++cnt[ranks[i]];
            ++suit[suits[i] - 'a'];
        }
        int maxCnt = 0, maxSuit = 0;
        for(int i = 1; i <= 13; ++i) {
            maxCnt = max(maxCnt, cnt[i]);
        }
        for(int i = 0; i < 4; ++i) {
            maxSuit = max(maxSuit, suit[i]);
        }
        if(maxSuit == 5) {
            return "Flush";
        }
        if(maxCnt == 3) {
            return "Three of a Kind";
        }
        if(maxCnt == 2) {
            for(int i = 1; i <= 13; ++i) {
                if(cnt[i] == 2) {
                    return "Pair";
                }
            }
        }
        return "High Card";
    }
};