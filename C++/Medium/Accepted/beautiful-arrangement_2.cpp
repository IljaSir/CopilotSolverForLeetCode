class Solution {
public:
    int countArrangement(int n) {
        
        vector<bool> used(n + 1, false);
        int ans = 0;
        function<void(int)> dfs = [&](int index) {
            if (index == n + 1) {
                ans++;
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (!used[i] && (i % index == 0 || index % i == 0)) {
                    used[i] = true;
                    dfs(index + 1);
                    used[i] = false;
                }
            }
        };
        dfs(1);
        return ans;
    }
};