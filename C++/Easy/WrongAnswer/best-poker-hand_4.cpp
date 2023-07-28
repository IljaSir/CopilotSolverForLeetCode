class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        
        unordered_map<int, int> count;
        for (int rank : ranks) {
            count[rank]++;
        }
        sort(ranks.begin(), ranks.end());
        bool flush = true;
        for (int i = 1; i < 5; i++) {
            flush &= suits[i] == suits[i - 1];
        }
        if (flush) {
            if (ranks[0] == 1 && ranks[1] == 10 && ranks[2] == 11 && ranks[3] == 12 && ranks[4] == 13) {
                return "Royal Flush";
            }
            for (int i = 1; i < 5; i++) {
                if (ranks[i - 1] + 1 != ranks[i]) {
                    return "Flush";
                }
            }
            return "Straight Flush";
        }
        if (count[ranks[0]] == 4 || count[ranks[1]] == 4) {
            return "Four of a Kind";
        }
        if (count[ranks[0]] == 3 && count[ranks[4]] == 2 || count[ranks[0]] == 2 && count[ranks[4]] == 3) {
            return "Full House";
        }
        if (count[ranks[0]] == 3 || count[ranks[1]] == 3 || count[ranks[2]] == 3) {
            return "Three of a Kind";
        }
        if (count[ranks[0]] == 2 && count[ranks[2]] == 2 || count[ranks[1]] == 2 && count[ranks[3]] == 2 || count[ranks[2]] == 2 && count[ranks[4]] == 2) {
            return "Two Pairs";
        }
        if (count[ranks[0]] == 2 || count[ranks[1]] == 2 || count[ranks[2]] == 2 || count[ranks[3]] == 2 || count[ranks[4]] == 2) {
            return "Pair";
        }
        for (int i = 1; i < 5; i++) {
            if (ranks[i - 1] + 1 != ranks[i]) {
                return "High Card";
            }
        }
        return "Straight";
    }
};