class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes[0].size();
        vector<vector<int>> cnt(26, vector<int>(n, 0));
        for (string vote : votes) {
            for (int i = 0; i < n; i++) {
                cnt[vote[i] - 'A'][i]++;
            }
        }
        sort(votes[0].begin(), votes[0].end(), [&](char a, char b) {
            for (int i = 0; i < n; i++) {
                if (cnt[a - 'A'][i] != cnt[b - 'A'][i]) {
                    return cnt[a - 'A'][i] > cnt[b - 'A'][i];
                }
            }
            return a < b;
        });
        return votes[0];
    }
};