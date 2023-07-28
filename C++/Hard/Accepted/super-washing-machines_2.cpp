class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        
        int sum = 0;
        for (int i = 0; i < machines.size(); i++) {
            sum += machines[i];
        }
        if (sum % machines.size() != 0) {
            return -1;
        }
        int avg = sum / machines.size();
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < machines.size(); i++) {
            cur += machines[i] - avg;
            ans = max(ans, max(abs(cur), machines[i] - avg));
        }
        return ans;
    }
};