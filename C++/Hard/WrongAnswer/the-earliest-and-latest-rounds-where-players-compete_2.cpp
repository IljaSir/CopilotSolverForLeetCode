class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        vector<int> res(2, 1);
        int round = 1;
        while (n > 2) {
            if ((firstPlayer + 1) / 2 != (secondPlayer + 1) / 2) {
                res[0] = round;
            }
            round++;
            n = (n + 1) / 2;
            firstPlayer = (firstPlayer + 1) / 2;
            secondPlayer = (secondPlayer + 1) / 2;
        }
        res[1] = round;
        return res;
    }
};