class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        int arr2_size = arr2.size();
        int arr1_size = arr1.size();
        vector<int> res;
        for(int i = 0; i < arr2_size; ++i){
            for(int j = 0; j < arr1_size; ++j){
                if(arr1[j] == arr2[i]){
                    res.push_back(arr1[j]);
                    arr1[j] = -1;
                }
            }
        }
        sort(arr1.begin(), arr1.end());
        for(int i = 0; i < arr1_size; ++i){
            if(arr1[i] != -1){
                res.push_back(arr1[i]);
            }
        }
        return res;
    }
};