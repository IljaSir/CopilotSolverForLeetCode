class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        
        int sum = accumulate(machines.begin(), machines.end(), 0);
        int n = machines.size();
        if (sum % n != 0) return -1;
        int avg = sum / n;
        int ans = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            int diff = machines[i] - avg;
            cur += diff;
            ans = max(ans, max(abs(cur), diff));
        }
        return ans;
    }
};