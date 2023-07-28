class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int round = 1;
        while (n > 2) {
            if ((firstPlayer + 1) / 2 == (secondPlayer + 1) / 2) break;
            round++;
            n = (n + 1) / 2;
            firstPlayer = (firstPlayer + 1) / 2;
            secondPlayer = (secondPlayer + 1) / 2;
        }
        return {round, round + (n > 2)};
    }
};