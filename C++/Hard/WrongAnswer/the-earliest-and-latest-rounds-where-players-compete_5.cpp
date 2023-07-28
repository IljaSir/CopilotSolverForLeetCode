class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int round = 0;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (firstPlayer <= mid && secondPlayer > mid) {
                break;
            } else if (firstPlayer > mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
            round++;
        }
        int minRound = round;
        int maxRound = 0;
        while (n > 1) {
            n = (n + 1) / 2;
            maxRound++;
        }
        return {minRound + 1, maxRound};
    }
};