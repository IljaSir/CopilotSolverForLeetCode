class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        
        int count[14] = {0};
        for (int i = 0; i < 5; i++) {
            count[ranks[i]]++;
        }
        int max = 0;
        for (int i = 1; i < 14; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        if (max == 3) {
            return "Three of a Kind";
        } else if (max == 2) {
            for (int i = 1; i < 14; i++) {
                if (count[i] == 2) {
                    return "Pair";
                }
            }
            return "High Card";
        } else {
            unordered_set<char> set;
            for (int i = 0; i < 5; i++) {
                set.insert(suits[i]);
            }
            if (set.size() == 1) {
                return "Flush";
            } else {
                return "High Card";
            }
        }
    }
};