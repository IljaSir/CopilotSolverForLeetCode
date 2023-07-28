class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        vector<int> result;
        vector<int> notInArr2;
        for (int i = 0; i < arr2.size(); i++) {
            for (int j = 0; j < arr1.size(); j++) {
                if (arr2[i] == arr1[j]) {
                    result.push_back(arr2[i]);
                }
            }
        }
        for (int i = 0; i < arr1.size(); i++) {
            bool isInArr2 = false;
            for (int j = 0; j < arr2.size(); j++) {
                if (arr1[i] == arr2[j]) {
                    isInArr2 = true;
                    break;
                }
            }
            if (!isInArr2) {
                notInArr2.push_back(arr1[i]);
            }
        }
        sort(notInArr2.begin(), notInArr2.end());
        for (int i = 0; i < notInArr2.size(); i++) {
            result.push_back(notInArr2[i]);
        }
        return result;
    }
};