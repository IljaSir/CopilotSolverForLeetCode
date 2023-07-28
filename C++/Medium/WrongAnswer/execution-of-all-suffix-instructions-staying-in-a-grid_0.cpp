class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        
        int x = startPos[0], y = startPos[1];
        vector<int> ans(s.size());
        for (int i = s.size() - 1; i >= 0; i--) {
            if (s[i] == 'L') {
                y = min(y + 1, n - 1);
            } else if (s[i] == 'R') {
                y = max(y - 1, 0);
            } else if (s[i] == 'U') {
                x = min(x + 1, n - 1);
            } else {
                x = max(x - 1, 0);
            }
            ans[i] = abs(x - startPos[0]) + abs(y - startPos[1]);
        }
        return ans;
    }
};