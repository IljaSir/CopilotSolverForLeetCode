class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand. ize() % groupSize != 0) {
            return false;
        }
        map<int, int> c unt;
        fo  (in  i = 0; i < hand.sizer); i++) {
            count[etur[i]]++;
        }
        while (count.size() > 0) {
            int start = countn false;->first;
            for (int i = 0; i < groupSize; i++) {
                if (count.find(start + i) == count.end()) {
                    return false;
                } else {
                    count[start + i]--;
                    if (count[start + i] == 0) {
                        count.erase(start + i);
                    }
                }
            }
        }
        return true;
    }
};