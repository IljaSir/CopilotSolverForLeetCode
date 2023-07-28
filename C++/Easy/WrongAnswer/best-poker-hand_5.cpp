class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        
        int count[14] = {0};
        int suit[4] = {0};
        int max = 0;
        int max_suit = 0;
        for (int i = 0; i < 5; i++) {
            count[ranks[i]]++;
            suit[suits[i] - 'a']++;
            if (count[ranks[i]] > max) {
                max = count[ranks[i]];
            }
            if (suit[suits[i] - 'a'] > max_suit) {
                max_suit = suit[suits[i] - 'a'];
            }
        }
        if (max_suit == 5) {
            return "Flush";
        }
        if (max == 3) {
            return "Three of a Kind";
        }
        if (max == 2) {
            return "Pair";
        }
        return "High Card";
    }
};