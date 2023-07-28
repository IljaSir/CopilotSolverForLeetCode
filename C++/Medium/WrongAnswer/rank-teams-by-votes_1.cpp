class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes.size();
        int m = votes[0].size();
        vector<vector<int>> count(m, vector<int>(26, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[j][votes[i][j] - 'A']++;
            }
        }
        vector<pair<int, string>> teams;
        for (int i = 0; i < 26; i++) {
            string team = "";
            team += ('A' + i);
            teams.push_back({i, team});
        }
        sort(teams.begin(), teams.end(), [&](pair<int, string> a, pair<int, string> b) {
            for (int i = 0; i < m; i++) {
                if (count[i][a.first] > count[i][b.first]) {
                    return true;
                } else if (count[i][a.first] < count[i][b.first]) {
                    return false;
                }
            }
            return a.second < b.second;
        });
        string res = "";
        for (auto it : teams) {
            res += it.second;
        }
        return res;
    }
};