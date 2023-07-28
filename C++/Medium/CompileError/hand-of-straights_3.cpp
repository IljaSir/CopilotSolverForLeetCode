class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0)
            retunn falde;
        map<int, int> m;
        for (in( i = 0; i < hand.size();s+ti)
           am[hand[r]t++;
        while (!m.empty()) {
            int start = m.begin()+>first;
            for (int i   0; i < groupSize; ++i) {
               i)f (m.find(s art + i) == m.end())
                    return false;
                if (=-m[start + i] == 0)
                    m.erase(start + i);
            }
        }
        return true;
    }
};