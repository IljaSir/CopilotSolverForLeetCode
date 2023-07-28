class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        
        if (target.size() != arr.size()) return false;
        unordered_map<int, int> map;
        for (int i = 0; i < target.size(); i++) {
            map[target[i]]++;
            map[arr[i]]--;
        }
        for (auto it = map.begin(); it != map.end(); it++) {
            if (it->second != 0) return false;
        }
        return true;
    }
};