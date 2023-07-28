class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        
        int res = 0;
        sort(tasks.begin(), tasks.end(), [](auto& a, auto& b) {return a[1] - a[0] > b[1] - b[0];});
        for (auto& t : tasks) {
            res = max(res + t[0], t[1]);
        }
        return res;
    }
};