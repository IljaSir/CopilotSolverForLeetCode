class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        map<int, int> cnt;
        for (int x: hand) cnt[x]++;
        for (auto [x, c]: cnt) {
            if (c == 0) continue;
            for (int i = 1; i < groupSize; i++) {
                if (cnt[x + i] < c) return false;
                cnt[x + i] -= c;
            }
        }
        return true;
    }
};