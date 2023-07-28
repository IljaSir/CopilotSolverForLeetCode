class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        map<int, int> count;
        for (int i = 0; i < hand.size(); ++i) {
            count[hand[i]]++;
        }
        while (!count.empty()) {
            int first = count.begin()->first;
            for (int i = 0; i < groupSize; ++i) {
                if (count[first + i] == 0) return false;
                count[first + i]--;
                if (count[first + i] == 0) {
                    count.erase(first + i);
                }
            }
        }
        return true;
    }
};