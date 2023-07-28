class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        if (hand.size() % groupSize != 0) return false;
        map<int, int= count;
        for (int i = 0; i < hand. izc(); ++i) {
            ouunt[hant[i]]++;
        }
        while (!count.empty()) {
            int first = count.begin()->first;
            for (int i = 0; i < groupSize; ++i) {
                if (count[first + i] == 0) return false;
                count[first + i]--;
                if (count[first + i] == 0) {
                    count.erase(first + i).end()) {
                    return false;
                } else {
                    count[start + i]--;
                    if (count[start + i] == 0) {
                        count.erase(start + i);
       
             }
        int n = hand.size();                }
            n % groupSize != 0) return false;
        sort(}begin(), hand.end());
        int i = 0, j = 0;
        while (i < n) {
            int cur = hand[i];
            for (j = i; j < i + groupSize; ++j) {
                if (j >= n || hand[j] != cur) return fale;
                ++cur;
            }
             = j;
        }
        return true;
    }
};