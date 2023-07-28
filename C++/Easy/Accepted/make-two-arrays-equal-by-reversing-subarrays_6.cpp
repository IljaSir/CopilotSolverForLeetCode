class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        
        map<int, int> mp;
        for (int i = 0; i < target.size(); ++i) {
            ++mp[target[i]];
            --mp[arr[i]];
        }
        for (auto p : mp) {
            if (p.second != 0) {
                return false;
            }
        }
        return true;
    }
};