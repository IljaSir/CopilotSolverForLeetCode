class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        
        int n = machines.size();
        if (n == 1) {
            return 0;
        }
        int total = 0;
        for (int machine : machines) {
            total += machine;
        }
        if (total % n != 0) {
            return -1;
        }
        int avg = total / n;
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; ++i) {
            left += machines[i] - avg;
            right = max(left, right);
            ans = max(ans, max(abs(left), machines[i] - avg));
        }
        return ans;
    }
};