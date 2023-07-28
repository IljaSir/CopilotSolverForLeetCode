class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        sort(hand.begin(), hand.end());
        map<int, int> m;
        for (int i = 0; i < hand.size(); i++) {
            m[hand[i]]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second > 0) {
                for (int i = 1; i < groupSize; i++) {
                    if (m.find(it->first + i) == m.end() || m[it->first + i] < it->second) return false;
                    m[it->first + i] -= it->second;
                }
            }
        }
        return true;
    }
};