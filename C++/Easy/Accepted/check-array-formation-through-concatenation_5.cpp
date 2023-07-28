class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        int n = arr.size();
        int m = pieces.size();
        int i = 0;
        while (i < n) {
            int j = 0;
            for (; j < m; j++) {
                if (pieces[j][0] == arr[i]) {
                    break;
                }
            }
            if (j == m) {
                return false;
            }
            int k = 0;
            while (k < pieces[j].size()) {
                if (arr[i] != pieces[j][k]) {
                    return false;
                }
                i++;
                k++;
            }
        }
        return true;
    }
};