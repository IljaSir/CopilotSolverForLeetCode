class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        vector<int> result;
        vector<int> arr1Count(1001, 0);
        for (int i = 0; i < arr1.size(); ++i) {
            arr1Count[arr1[i]]++;
        }
        for (int i = 0; i < arr2.size(); ++i) {
            while (arr1Count[arr2[i]] > 0) {
                result.push_back(arr2[i]);
                arr1Count[arr2[i]]--;
            }
        }
        for (int i = 0; i < arr1Count.size(); ++i) {
            while (arr1Count[i] > 0) {
                result.push_back(i);
                arr1Count[i]--;
            }
        }
        return result;
    }
};