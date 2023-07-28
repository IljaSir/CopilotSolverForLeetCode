class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < arr.size(); i++) {
            if (m.find(arr[i]) == m.end()) {
                m[arr[i]] = 1;
            } else {
                m[arr[i]]++;
            }
        }
        unordered_set<int> s;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (s.find(it->second) == s.end()) {
                s.insert(it->second);
            } else {
                return false;
            }
        }
        return true;
    }
};