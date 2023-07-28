class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int rounds = 0;
        while (n > 1) {
            ++rounds;
            if (firstPlayer > n - firstPlayer + 1) {
                firstPlayer = n - firstPlayer + 1;
            }
            if (secondPlayer > n - secondPlayer + 1) {
                secondPlayer = n - secondPlayer + 1;
            }
            n = (n + 1) / 2;
        }
        return {rounds, rounds + (firstPlayer != secondPlayer)};
    }
};