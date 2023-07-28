class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        map<int, int> cnt;
        for (int x: hand) cnt[x]++;
        while (!cnt.empty()) {
            int x = cnt.begin()->first;
            for (int i = 0; i < groupSize; i++) {
                if (cnt[x + i] == 0) return false;
                if (--cnt[x + i] == 0) cnt.erase(x + i);
            }
        }
        return true;
    }
};