class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        
        map<int, int> rankCount;
        map<char, int> suitCount;
        for (auto r : ranks) {
            rankCount[r]++;
        }
        for (auto s : suits) {
            suitCount[s]++;
        }
        bool isFlush = false;
        for (auto s : suitCount) {
            if (s.second == 5) {
                isFlush = true;
                break;
            }
        }
        bool isThreeOfAKind = false;
        bool isPair = false;
        for (auto r : rankCount) {
            if (r.second == 3) {
                isThreeOfAKind = true;
            }
            if (r.second == 2) {
                isPair = true;
            }
        }
        if (isFlush) {
            return "Flush";
        }
        if (isThreeOfAKind) {
            return "Three of a Kind";
        }
        if (isPair) {
            return "Pair";
        }
        return "High Card";
    }
};