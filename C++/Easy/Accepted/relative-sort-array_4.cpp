class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        vector<int> res;
        map<int, int> mp;
        for (int i = 0; i < arr1.size(); i++) {
            if (mp.find(arr1[i]) == mp.end()) {
                mp[arr1[i]] = 1;
            } else {
                mp[arr1[i]]++;
            }
        }
        for (int i = 0; i < arr2.size(); i++) {
            int num = mp[arr2[i]];
            for (int j = 0; j < num; j++) {
                res.push_back(arr2[i]);
            }
            mp.erase(arr2[i]);
        }
        for (auto it = mp.begin(); it != mp.end(); it++) {
            int num = it->second;
            for (int j = 0; j < num; j++) {
                res.push_back(it->first);
            }
        }
        return res;
    }
};