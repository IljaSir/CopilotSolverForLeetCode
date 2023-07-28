class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        
        vector<vector<int>> result;
        int n = pairs.size();
        int i = 0;
        while (i < n) {
            result.push_back(pairs[i]);
            if (i + 1 < n) {
                if (pairs[i][1] == pairs[i + 1][0]) {
                    i++;
                } else if (pairs[i][1] == pairs[i + 1][1]) {
                    swap(pairs[i + 1][0], pairs[i + 1][1]);
                    i++;
                } else if (pairs[i][0] == pairs[i + 1][0]) {
                    swap(pairs[i][0], pairs[i][1]);
                    i++;
                } else if (pairs[i][0] == pairs[i + 1][1]) {
                    swap(pairs[i][0], pairs[i][1]);
                    swap(pairs[i + 1][0], pairs[i + 1][1]);
                    i++;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return result;
    }
};