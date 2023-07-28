class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes.size();
        int m = votes[0].size();
        vector<vector<int>> count(26, vector<int>(m + 1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[votes[i][j] - 'A'][j]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            count[i][m] = i;
        }
        sort(count.begin(), count.end(), [](const vector<int>& a, const vector<int>& b) {
            for (int i = 0; i < a.size(); i++) {
                if (a[i] > b[i]) return true;
                if (a[i] < b[i]) return false;
            }
            return false;
        });
        string ans;
        for (int i = 0; i < 26; i++) {
            if (count[i][m] > 0) {
                ans += 'A' + count[i][m];
            }
        }
        return ans;
    }
};