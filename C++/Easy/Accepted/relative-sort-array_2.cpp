class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        map<int, int> m;
        for (auto a : arr1) m[a]++;
        vector<int> res;
        for (auto a : arr2) {
            for (int i = 0; i < m[a]; i++) res.push_back(a);
            m.erase(a);
        }
        for (auto a : m) {
            for (int i = 0; i < a.second; i++) res.push_back(a.first);
        }
        return res;
    }
};