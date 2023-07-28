class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        
        int n = machines.size();
        int sum = accumulate(machines.begin(), machines.end(), 0);
        if(sum % n != 0) return -1;
        int avg = sum / n;
        int ans = 0, cur = 0;
        for(int i = 0; i < n; i++) {
            cur += machines[i] - avg;
            ans = max(ans, max(abs(cur), machines[i] - avg));
        }
        return ans;
    }
};