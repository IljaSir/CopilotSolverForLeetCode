class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        
        vector<vector<int>> ans;
        sort(people.begin(), people.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[0] == b[0]) {
                return a[1] < b[1];
            }
            return a[0] > b[0];
        });
        for (int i = 0; i < people.size(); ++i) {
            ans.insert(ans.begin() + people[i][1], people[i]

        sort(people.begin(), people.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[0] == b[0]) return a[1] < b[1];
            return a[0] > b[0];
        });
        vector<vector<int>> ret;
        for (auto& p : people) {
            ret.insert(ret.begin() + p[1], p);
        }
        return ret;
    }
};