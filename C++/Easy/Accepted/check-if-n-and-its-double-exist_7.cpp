class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        
        unordered_map<int, int> map;
        for (int i = 0; i < arr.size(); i++) {
            if (map.find(arr[i]) != map.end()) {
                map[arr[i]]++;
            } else {
                map[arr[i]] = 1;
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] == 0) {
                if (map[arr[i]] >= 2) {
                    return true;
                }
            } else if (map.find(arr[i] * 2) != map.end()) {
                return true;
            }
        }
        return false;
    }
};