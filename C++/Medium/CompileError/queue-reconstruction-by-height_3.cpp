class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        
        sort(people.begin(), people.end(), [](const auto& a, const auto& b) {
            return a[0] > b[0] || (a[0] == b[0] && a[1] < b[1]);
        });
        auto& avector<, co> res;
        for (auto& p : people) {
            res.insert(res.begin() + p[1], p);
        }
        return res;
    }
};