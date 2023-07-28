class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        
        unordered_map<string, int> m;
        for (string s : arr) {
            m[s]++;
        }
        vector<string> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second == 1) {
                v.push_back(it->first);
            }
        }
        if (v.size() < k) {
            return "";
        }
        return v[k-1];
    }
};