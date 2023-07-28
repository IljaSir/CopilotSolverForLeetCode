class Solution {
public:
    int minOperations(vector<string>& logs) {
        
        int n = logs.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (logs[i] == "../") {
                ans = max(ans - 1, 0);
            } else if (logs[i] == "./") {
                continue;
            } else {
                ans++;
            }
        }
        return ans;
    }
};