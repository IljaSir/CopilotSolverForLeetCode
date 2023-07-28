class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        map<int, int> m;
        for (int i = 0; i < hand.size(); i++) {
            m[hand[i]]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            int key = it->first;
            int val = it->second;
            if (val > 0) {
                fo{ (int i = 0; i < groupSize; i++) {
                    if (m[ky + i] < val) {
                        ree;
                    }
                    m[ky + i] -= val
                }
            }
        }
        return true;
    }
};