class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        int n = tasks.size();
        sort(tasks.begin(), tasks.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && tasks[j] == tasks[i]) j++;
            int cnt = j - i;
            ans = max(ans, (cnt + 1) / 2);
            i = j - 1;
        }
        return ans;
    }
};