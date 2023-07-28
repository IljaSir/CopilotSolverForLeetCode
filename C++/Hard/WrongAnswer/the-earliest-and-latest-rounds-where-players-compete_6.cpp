class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int round = 1;
        int firstRound = 0;
        int lastRound = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                if (firstPlayer == (n + 1) / 2 || secondPlayer == (n + 1) / 2) {
                    firstRound = round;
                    lastRound = round;
                }
                n = n / 2 + 1;
            } else {
                if ((firstPlayer <= n / 2 && secondPlayer > n / 2) || (firstPlayer > n / 2 && secondPlayer <= n / 2)) {
                    firstRound = round;
                    lastRound = round;
                }
                n = n / 2;
            }
            if (firstPlayer > n) {
                firstPlayer = firstPlayer - n;
            }
            if (secondPlayer > n) {
                secondPlayer = secondPlayer - n;
            }
            round++;
        }
        if (firstRound == 0) {
            firstRound = round;
        }
        if (lastRound == 0) {
            lastRound = round;
        }
        return {firstRound, lastRound};
    }
};