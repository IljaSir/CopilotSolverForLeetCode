class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        vector<int> res;
        int start = 1;
        int end = n;
        int round = 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if ((firstPlayer <= mid && secondPlayer > mid) || (firstPlayer > mid && secondPlayer <= mid)) {
                res.push_back(round);
                res.push_back(round);
                return res;
            }
            if (firstPlayer <= mid && secondPlayer <= mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
            ++round;
        }
        res.push_back(round);
        res.push_back(round);
        return res;
    }
};