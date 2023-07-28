class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < arr.size(); i++) {
            m[arr[i]]++;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] == 0) {
                if (m[0] >= 2) {
                    return true;
                }
            } else {
                if (m[arr[i] * 2] >= 1) {
                    return true;
                }
            }
        }
        return false;
    }
};