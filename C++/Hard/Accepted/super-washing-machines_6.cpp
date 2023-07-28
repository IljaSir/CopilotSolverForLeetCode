class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        
        int sum = accumulate(machines.begin(), machines.end(), 0);
        if (sum % machines.size() != 0) return -1;
        int avg = sum / machines.size();
        int res = 0, cnt = 0;
        for (int load : machines) {
            cnt += load - avg;
            res = max(res, max(abs(cnt), load - avg));
        }
        return res;
    }
};