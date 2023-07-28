class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        
        sort(tasks.begin(), tasks.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] - a[0] > b[1] - b[0];
        });
        int res = 0, cur = 0;
        for (auto& t : tasks) {
            res = max(res, cur + t[1]);
            cur += t[0];
        }
        return res;
    }
};