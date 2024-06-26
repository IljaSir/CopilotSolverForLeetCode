class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < pieces.size(); i++) {
            m[pieces[i][0]] = i;
        }
        int i = 0;
        while (i < arr.size()) {
            if (m.count(arr[i]) == 0) {
                return false;
            }
            int j = 0;
            while (j < pieces[m[arr[i]]].size()) {
                if (arr[i] != pieces[m[arr[i]]][j]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }
};