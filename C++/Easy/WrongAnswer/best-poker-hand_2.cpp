class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        
        int flush = 0;
        for (auto c : suits) {
            if (c == suits[0]) {
                flush++;
            }
        }
        if (flush == 5) {
            return "Flush";
        }
        unordered_map<int, int> m;
        for (auto n : ranks) {
            m[n]++;
        }
        int three = 0;
        int pair = 0;
        for (auto n : m) {
            if (n.second == 3) {
                three = 1;
            }
            if (n.second == 2) {
                pair++;
            }
        }
        if (three == 1) {
            return "Three of a Kind";
        }
        if (pair == 2) {
            return "Two Pairs";
        }
        if (pair == 1) {
            return "Pair";
        }
        return "High Card";
    }
};