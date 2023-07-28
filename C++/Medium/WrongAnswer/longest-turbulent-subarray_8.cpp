class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        if (n == 1) return 1;
        int ans = 0;
        int cnt = 1;
        int sign = 0;
        for (int i = 1; i < n; i++) {
            int cur = arr[i] - arr[i - 1];
            if (cur == 0) {
                cnt = 1;
                sign = 0;
                continue;
            }
            if (cur * sign > 0) {
                cnt++;
            } else {
                cnt = 2;
            }
            sign = cur;
            ans = max(ans, cnt);
        }
        return ans;
    }
};