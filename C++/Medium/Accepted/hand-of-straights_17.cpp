class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0)
            return false;
        
        map<int, int> m;
        for (auto item : hand) {
            m[item]++;
        }
        
        while (m.size() > 0) {
            auto it = m.begin();
            int start = it->first;
            for (int i = 0; i < groupSize; i++) {
                if (m.find(start + i) == m.end())
                    return false;
                m[start + i]--;
                if (m[start + i] == 0)
                    m.erase(start + i);
            }
        }
        return true;
    }
};