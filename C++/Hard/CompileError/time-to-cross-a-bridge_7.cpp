class Solution {
public:
    int findCrossingTime(int n, int k, vector<vector<int>>& time) {
        
        vector<int> cur(k, 0);
        vector<int> last(k, 0);
        vector<int> next(k, 0);
        vector<int> nextLast(k, 0);
        vector<int> waiting(k, 0);
        vector<int> waitingLast(k, 0);
        vector<int> waitingNext(k, 0);
        vector<int> waitingNextLast(k, 0);
        vector<int> lastLeft(k, 0);
        vector<int> nextLeft(k, 0);
        vector<int> lastRight(k, 0);
        vector<int> nextRight(k, 0);
        vector<int> lastLeftWaiting(k, 0);
        vector<int> nextLeftWaiting(k, 0);
        vector<int> lastRightWaiting(k, 0);
        vector<int> nextRightWaiting(k, 0);
        vector<int> lastLeftWaitingLast(k, 0);
        vector<int> nextLeftWaitingLast(k, 0);
        vector<int> lastRightWaitingLast(k, 0);
        vector<int> nextRightWaitingLast(k, 0);
        vector<int> lastLeftWaitingNext(k, 0);
        vector<int> nextLeftWaitingNext(k, 0);
        vector<int> lastRightWaitingNext(k, 0);
        vector<int> nextRightWaitingNext(k, 0);
        vector<int> lastLeftWaitingNextLast(k, 0);
        vector<int> nextLeftWaitingNextLast(k, 0);
        vector<int> lastRightWaitingNextLast(k, 0);
        vector<int> nextRightWaitingNextLast(k, 0);
        for (int i = 0; i < k; ++i) {
            last[i] = time[i][0];
            lastLeft[i] = time[i][0];
            lastRight[i] = time[i][2];
            lastLeftWaitingLast[i] = time[i][0];
            lastRightWaitingLast[i] = time[i][2];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
                next[j] = 1000000000;
                nextLeft[j] = 1000000000;
                nextRight[j] = 1000000000;
                nextLeftWaiting[j] = 1000000000;
                nextRight
    }
};