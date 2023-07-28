class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        
        unordered_map<int, int> m;
        for (auto x: arr) m[x]++;
        unordered_set<int> s;
        for (auto x: m) {
            if (s.count(x.second)) return false;
            s.insert(x.second);
        }
        return true;
    }
};