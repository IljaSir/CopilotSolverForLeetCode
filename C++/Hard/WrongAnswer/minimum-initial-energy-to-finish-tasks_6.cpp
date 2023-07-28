class Solution {
public:
    int minimumEffort(vector<vector<int>>& tasks) {
        
        sort(tasks.begin(), tasks.end(), [](const vector<int> &a, const vector<int> &b) {return a[1] - a[0] > b[1] - b[0];});
        int ans = 0;
        for (const auto &t : tasks) {
            ans = max(ans + t[0], t[1]);
        }
        return ans;
    }
};