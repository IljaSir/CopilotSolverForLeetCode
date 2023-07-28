class Solution {
public:
    vector<vector<int>> reconstructMatrix(int upper, int lower, vector<int>& colsum) {
        
        vector<vector<int>> ret;
        int n = colsum.size();
        int sum = 0;
        for (auto i : colsum) sum += i;
        if (sum != upper + lower) return ret;
        vector<int> upperRow(n, 0);
        vector<int> lowerRow(n, 0);
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                upperRow[i] = 1;
                lowerRow[i] = 1;
                upper--;
                lower--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    upperRow[i] = 1;
                    upper--;
                } else {
                    lowerRow[i] = 1;
                    lower--;
                }
            }
        }
        ret.push_back(upperRow);
        ret.push_back(lowerRow);
        return ret;
    }
};