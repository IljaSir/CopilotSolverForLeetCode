class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < arr.size(); i++) {
            m[arr[i]] = i;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] % 2 == 0) {
                if (m.count(arr[i] / 2) && m[arr[i] / 2] != i) {
                    return true;
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (m.count(2 * arr[i]) && m[2 * arr[i]] != i) {
                return true;
            }
        }
        return false;
    }
};