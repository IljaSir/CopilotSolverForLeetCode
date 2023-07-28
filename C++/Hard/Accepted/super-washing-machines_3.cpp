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
        int res = 0;
        int cur = 0;
        for (int i = 0; i < machines.size(); i++) {
            cur += machines[i] - avg;
            res = max(res, abs(cur));
            res = max(res, machines[i] - avg);
        }
        return res;
    }
};