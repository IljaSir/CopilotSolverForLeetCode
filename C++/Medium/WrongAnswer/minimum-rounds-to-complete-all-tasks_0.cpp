class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        int n = tasks.size();
        if (n == 0) return 0;
        sort(tasks.begin(), tasks.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (tasks[i] % 2 == 1) {
                ans++;
                tasks[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (tasks[i] == 0) continue;
            int d = tasks[i] / 2;
            int j = i + 1;
            while (j < n && tasks[j] == 0) j++;
            if (j < n && tasks[j] == tasks[i]) {
                tasks[j] -= 2;
                ans += d;
            } else {
                ans += d + 1;
            }
        }
        return ans;
    }
};