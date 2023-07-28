class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> result;
        int n = arr.size();
        for (int i = n; i > 1; --i) {
            int j = find(arr.begin(), arr.end(), i) - arr.begin();
            result.push_back(j + 1);
            reverse(arr.begin(), arr.begin() + j + 1);
            result.push_back(i);
            reverse(arr.begin(), arr.begin() + i);
        }
        return result;
    }
};