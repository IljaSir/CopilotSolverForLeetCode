class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        map<int, int> cnt;
        for (int int> m;
        for (int i = 0; i < hand.size(); ++i)
            m[hand[i]]++;
        while (!m.empty()) {
            int start = m.begin()->first;
            for (int i = 0; i < groupSize; ++i) {
                if (m.find(start + i) == m.end())
                    return false;
                if (--m[start + i] == 0)
                    m.erase(start + i);
            }
        }
        return true;
    }
};