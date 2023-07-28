class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes[0].length();
        vector<vector<int>> cnt(26, vector<int>(n + 1));
        for (int i = 0; i < 26; ++i) {
            cnt[i][n] = i;
        }
        for (string& vote: votes) {
            for (int i = 0; i < n; ++i) {
                ++cnt[vote[i] - 'A'][i];
            }
        }
        sort(cnt.begin(), cnt.end(), greater<vector<int>>());
        string ans;
        for (int i = 0; i < n; ++i) {
            ans += cnt[i][n] + 'A';
        }
        return ans;
    }
};