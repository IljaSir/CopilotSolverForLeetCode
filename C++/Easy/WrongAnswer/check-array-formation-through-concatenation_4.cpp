class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        int n = arr.size();
        int m = pieces.size();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr[i] == pieces[j][0]) {
                int k = 0;
                while (k < pieces[j].size() && i < n) {
                    if (arr[i] != pieces[j][k]) {
                        return false;
                    }
                    i++;
                    k++;
                }
                j++;
            } else {
                i++;
            }
        }
        return j == m;
    }
};