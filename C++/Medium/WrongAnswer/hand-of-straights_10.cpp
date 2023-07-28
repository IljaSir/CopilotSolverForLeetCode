class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        
        int n = hand.size();
        if (n % groupSize != 0) return false;
        sort(hand.begin(), hand.end());
        int i = 0, j = 0;
        while (i < n) {
            int cur = hand[i];
            for (j = i; j < i + groupSize; ++j) {
                if (j >= n || hand[j] != cur) return false;
                ++cur;
            }
            i = j;
        }
        return true;
    }
};