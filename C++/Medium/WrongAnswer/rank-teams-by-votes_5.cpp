class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes[0].size();
        vector<vector<int>> cnt(26, vector<int>(n+1, 0));
        for (int i = 0; i < n; i++) {
            cnt[votes[0][i] - 'A'][n] = votes[0][i] - 'A';
        }
        for (string vote : votes) {
            for (int i = 0; i < n; i++) {
                cnt[vote[i] - 'A'][i]++;
            }
        }
        sort(cnt.begin(), cnt.end(), [](vector<int> &a, vector<int> &b) {
            for (int i = 0; i < a.size(); i++) {
                if (a[i] != b[i]) {
                    return a[i] > b[i];
                }
            }
            return false;
        });
        string res;
        for (int i = 0; i < n; i++) {
            res += char(cnt[i][n] + 'A');
        }
        return res;
    }
};