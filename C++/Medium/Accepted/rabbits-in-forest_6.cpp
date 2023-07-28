class Solution {
public:
    int numRabbits(vector<int>& answers) {
        
        int n = answers.size();
        if (n == 0) return 0;
        sort(answers.begin(), answers.end());
        int ans = 1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (answers[i] == answers[i - 1]) {
                cnt++;
                if (cnt > answers[i] + 1) {
                    ans += answers[i] + 1;
                    cnt = 1;
                }
            } else {
                ans += answers[i - 1] + 1;
                cnt = 1;
            }
        }
        ans += answers[n - 1];
        return ans;
    }
};