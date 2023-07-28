class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        int len = arr.size();
        int i = 0;
        while (i < len) {
            int j = 0;
            for (; j < pieces.size(); j++) {
                if (pieces[j][0] == arr[i]) {
                    break;
                }
            }
            if (j == pieces.size()) {
                return false;
            }
            for (int k = 0; k < pieces[j].size(); k++) {
                if (pieces[j][k] != arr[i]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
};