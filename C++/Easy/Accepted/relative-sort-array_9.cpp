class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        
        auto it = arr1.begin();
        for (auto i : arr2) {
            it = partition(it, arr1.end(), [i](int a){return a == i;});
        }
        sort(it, arr1.end());
        return arr1;
    }
};