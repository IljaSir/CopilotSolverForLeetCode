class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        map<int, int> mp;
        for (auto h : hand) mp[h]++;
        for (auto p : mp) {
            if (p.second > 0) {
                for (int i = 0; i < groupSize; i++) {
                    if (mp[p.first + i] < p.second) return false;
                    mp[p.first + i] -= p.second;
                }
            }
        }
        return true;
    }
};