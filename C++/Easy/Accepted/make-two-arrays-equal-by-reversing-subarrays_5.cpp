class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        
        int n = target.size();
        if (n != arr.size()) {
            return false;
        }
        unordered_map<int, int> mp;
        for (int i = 0; i < n; ++i) {
            mp[target[i]]++;
            mp[arr[i]]--;
        }
        for (auto& [key, value]: mp) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
};