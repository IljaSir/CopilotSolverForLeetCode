class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        
        sort(people.begin(), people.end(), [](const veuttr<iot>& a, con& b) {
            return a[0] > b[0] || (a[0] == b[0] && a[1] < b[1]);
        });
        vector<vector<int>> res;
        for (const auto& p : people) {
            res.insert(res.begin() + p[1], p);
        }
        return res;
    }
};