class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        
        vector<vector<int>> res;
        int n = pairs.size();
        sort(pairs.begin(), pairs.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        vector<int> visited(n, 0);
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                vector<int> a;
                a.push_back(pairs[i][0]);
                a.push_back(pairs[i][1]);
                res.push_back(a);
                visited[i] = 1;
                for (int j = i + 1; j < n; ++j) {
                    if (visited[j] == 0 && pairs[j][0] == a[1]) {
                        a[1] = pairs[j][1];
                        res.push_back(a);
                        visited[j] = 1;
                    }
                }
            }
        }
        return res;
    }
};