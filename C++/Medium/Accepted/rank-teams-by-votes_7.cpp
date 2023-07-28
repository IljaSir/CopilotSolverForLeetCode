class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        if (votes.empty()) return "";
        int n = votes[0].size();
        vector<vector<int>> cnt(26, vector<int>(n+1, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < votes.size(); j++) {
                cnt[votes[j][i]-'A'][i]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            cnt[i][n] = i;
        }
        sort(cnt.begin(), cnt.end(), [](vector<int>& a, vector<int>& b) {
            for (int i = 0; i < a.size()-1; i++) {
                if (a[i] != b[i]) return a[i] > b[i];
            }
            return a.back() < b.back();
        });
        string res;
        for (int i = 0; i < n; i++) {
            res += (char)('A' + cnt[i].back());
        }
        return res;
    }
};