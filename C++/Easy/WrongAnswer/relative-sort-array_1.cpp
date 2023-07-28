class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < arr1.size(); ++i) {
            m[arr1[i]]++;
        }
        vector<int> result;
        for (int i = 0; i < arr2.size(); ++i) {
            while (m[arr2[i]] > 0) {
                result.push_back(arr2[i]);
                m[arr2[i]]--;
            }
        }
        for (auto it = m.begin(); it != m.end(); ++it) {
            while (it->second > 0) {
                result.push_back(it->first);
                it->second--;
            }
        }
        return result;
    }
};