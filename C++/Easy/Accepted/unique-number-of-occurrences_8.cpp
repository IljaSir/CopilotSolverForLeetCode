class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        
        map<int, int> m;
        for(int i : arr) {
            m[i]++;
        }
        set<int> s;
        for(auto it=m.begin(); it!=m.end(); it++) {
            s.insert(it->second);
        }
        return s.size() == m.size();
    }
};