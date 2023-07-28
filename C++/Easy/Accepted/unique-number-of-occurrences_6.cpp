class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        
        std::unordered_map<int, int> m;
        for (auto i : arr) {
            ++m[i];
        }
        std::unordered_set<int> s;
        for (auto i : m) {
            if (s.find(i.second) != s.end()) {
                return false;
            }
            s.insert(i.second);
        }
        return true;
    }
};