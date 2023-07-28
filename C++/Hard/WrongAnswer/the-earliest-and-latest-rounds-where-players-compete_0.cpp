class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int round = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                if (firstPlayer == n / 2 + 1 || secondPlayer == n / 2 + 1) {
                    break;
                }
                if (firstPlayer > n / 2 + 1) {
                    firstPlayer -= n / 2 + 1;
                }
                if (secondPlayer > n / 2 + 1) {
                    secondPlayer -= n / 2 + 1;
                }
            } else {
                if (firstPlayer == n / 2 || secondPlayer == n / 2) {
                    break;
                }
                if (firstPlayer > n / 2) {
                    firstPlayer -= n / 2;
                }
                if (secondPlayer > n / 2) {
                    secondPlayer -= n / 2;
                }
            }
            n /= 2;
            ++round;
        }
        return {round + 1, round + 1};
    }
};