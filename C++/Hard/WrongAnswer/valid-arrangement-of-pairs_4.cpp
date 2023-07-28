class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        
        int n = pairs.size();
        vector<vector<int>> res;
        vector<int> temp;
        sort(pairs.begin(), pairs.end(), [](vector<int> a, vector<int> b) {
            return a[1] < b[1];
        });
        temp.push_back(pairs[0][0]);
        temp.push_back(pairs[0][1]);
        res.push_back(temp);
        temp.clear();
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] == res[i - 1][1]) {
                temp.push_back(pairs[i][0]);
                temp.push_back(pairs[i][1]);
                res.push_back(temp);
                temp.clear();
            }
            else {
                temp.push_back(pairs[i][1]);
                temp.push_back(pairs[i][0]);
                res.push_back(temp);
                temp.clear();
            }
        }
        return res;
    }
};