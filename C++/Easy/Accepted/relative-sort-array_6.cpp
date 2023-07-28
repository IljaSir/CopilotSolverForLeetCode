class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        vector<int> ans;
        map<int, int> map1;
        for (int i = 0; i < arr1.size(); i++) {
            map1[arr1[i]]++;
        }
        for (int i = 0; i < arr2.size(); i++) {
            for (int j = 0; j < map1[arr2[i]]; j++) {
                ans.push_back(arr2[i]);
            }
            map1.erase(arr2[i]);
        }
        for (auto it = map1.begin(); it != map1.end(); it++) {
            for (int j = 0; j < it->second; j++) {
                ans.push_back(it->first);
            }
        }
        return ans;
    }
};