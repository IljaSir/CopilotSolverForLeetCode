class Solution {
public:
    vector<vector<int>> sortTheStudents(vector<vector<int>>& score, int k) {
        
        vector<pair<int, int>> v;
        int n = score.size();
        for (int i = 0; i < n; i++) {
            v.push_back({score[i][k], i});
        }
        sort(v.begin(), v.end(), greater<pair<int, int>>());
        vector<vector<int>> ans;
        for (auto &p : v) {
            ans.push_back(score[p.second]);
        }
        return ans;
    }
};