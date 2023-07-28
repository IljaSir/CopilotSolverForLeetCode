class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        int n = arr.size();
        int m = pieces.size();
        int i = 0;
        int j = 0;
        int k = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (arr[i] == pieces[j][0]) {
                    for (k = 0; k < pieces[j].size(); k++) {
                        if (arr[i + k] != pieces[j][k]) {
                            return false;
                        }
                    }
                    i += k - 1;
                    break;
                }
            }
            if (j == m) {
                return false;
            }
        }
        return true;
    }
};