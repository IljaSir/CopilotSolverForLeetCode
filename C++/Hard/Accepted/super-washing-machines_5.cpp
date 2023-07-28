class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        
        int sum = 0;
        for (int m : machines) {
            sum += m;
        }
        if (sum % machines.size() != 0) {
            return -1;
        }
        int avg = sum / machines.size();
        int ans = 0;
        int cnt = 0;
        for (int m : machines) {
            cnt += m - avg;
            ans = max(ans, max(abs(cnt), m - avg));
        }
        return ans;
    }
};