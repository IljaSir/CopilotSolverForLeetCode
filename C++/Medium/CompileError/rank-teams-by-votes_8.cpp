class Solution {
public:
    string rankTeams(vector<string>& votes) {
        
        int n = votes[0].size();
        vector<vector<int>> v(26, vector<int>(n,0));
        for (auto vote: votes) {
            for (int i=0; i<n; i++) {
                v[vote[i]-'A'][i]++;
            }
        }
        sort(v.begin(), v.end(), [](vector<int> &a, vector<int> &b) {
            for (int i=0; i<a.size(); i++) {
                if (a[i] > b[i]) return true;
                if (a[i] < b[i]) return false;
            }
            return false;
        });
        string result = "";
        for (auto &v : v) {
            if (v[0] == 0) break;
            result += 'A' + (&v-&v[0]);
        }
        return result;
    }
};