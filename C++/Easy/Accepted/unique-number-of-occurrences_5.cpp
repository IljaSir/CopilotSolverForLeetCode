class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        
        map<int, int> m;
        for (int i = 0; i < arr.size(); i++) {
            m[arr[i]]++;
        }
        vector<int> v;
        for (auto i = m.begin(); i != m.end(); i++) {
            v.push_back(i->second);
        }
        sort(v.begin(), v.end());
        for (int i = 0; i < v.size() - 1; i++) {
            if (v[i] == v[i + 1]) {
                return false;
            }
        }
        return true;
    }
};