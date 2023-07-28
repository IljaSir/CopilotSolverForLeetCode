class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        
        int n = target.size();
        unordered_map<int, int> m1, m2;
        for (int i = 0; i < n; ++i) {
            m1[target[i]]++;
            m2[arr[i]]++;
        }
        for (auto it = m1.begin(); it != m1.end(); ++it) {
            if (m2[it->first] != it->second) return false;
        }
        return true;
    }
};