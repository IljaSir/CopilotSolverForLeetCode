class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int l = 0, r = n - 1;
        int l1 = 0, r1 = n - 1;
        int round = 0;
        while (l < r) {
            int mid = (l + r) / 2;
            if (firstPlayer <= mid && secondPlayer > mid || firstPlayer > mid && secondPlayer <= mid) {
                l1 = l;
                r1 = r;
                round++;
            }
            if (firstPlayer <= mid && secondPlayer <= mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int round1 = round;
        l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (firstPlayer <= mid && secondPlayer > mid || firstPlayer > mid && secondPlayer <= mid) {
                round++;
            }
            if (firstPlayer <= mid && secondPlayer <= mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return {round1, round};
    }
};