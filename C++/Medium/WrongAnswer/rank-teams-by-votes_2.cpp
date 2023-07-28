class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes[0].size();
        vector<vector<int>> cnt(26, vector<int>(n + 1));
        for (int i = 0; i < n; i++) {
            cnt[votes[0][i] - 'A'][n] = votes[0][i];
            for (auto & vote : votes) {
                cnt[vote[i] - 'A'][i]++;
            }
        }
        sort(cnt.begin(), cnt.end(), [](const vector<int> & u, const vector<int> & v) {
            for (int i = 0; i < u.size(); i++) {
                if (u[i] > v[i]) {
                    return true;
                } else if (u[i] < v[i]) {
                    return false;
                }
            }
            return false;
        });
        string ans;
        for (int i = 0; i < n; i++) {
            ans.push_back(cnt[i][n]);
        }
        return ans;
    }
};