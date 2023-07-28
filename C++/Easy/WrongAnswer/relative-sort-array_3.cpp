class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        vector<int> res;
        sort(arr1.begin(), arr1.end());
        int j = 0;
        for (int i = 0; i < arr2.size(); i++) {
            while (j < arr1.size() && arr1[j] < arr2[i]) {
                res.push_back(arr1[j++]);
            }
            while (j < arr1.size() && arr1[j] == arr2[i]) {
                res.push_back(arr1[j++]);
            }
        }
        while (j < arr1.size()) {
            res.push_back(arr1[j++]);
        }
        return res;
    }
};