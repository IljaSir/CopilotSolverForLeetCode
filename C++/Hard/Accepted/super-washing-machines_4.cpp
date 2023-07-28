class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        
        int sum = accumulate(machines.begin(), machines.end(), 0);
        int n = machines.size();
        if (sum % n) return -1;
        int avg = sum / n;
        int ans = 0, cnt = 0;
        for (int num : machines) {
            num -= avg;
            cnt += num;
            ans = max(ans, max(abs(cnt), num));
        }
        return ans;
    }
};