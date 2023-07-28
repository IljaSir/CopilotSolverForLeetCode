class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes[0].size();
        vector<vector<int>> count(26, vector<int>(n + 1, 0));
        for (int i = 0; i < votes.size(); i++) {
            for (int j = 0; j < n; j++) {
                count[votes[i][j] - 'A'][j]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            count[i][n] = i;
        }
        sort(count.begin(), count.end(), [](const vector<int>& a, const vector<int>& b) {
            for (int i = 0; i < a.size() - 1; i++) {
                if (a[i] != b[i]) {
                    return a[i] > b[i];
                }
            }
            return a.back() < b.back();
        });
        string ans;
        for (int i = 0; i < n; i++) {
            ans += 'A' + count[i].back();
        }
        return ans;
    }
};