class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> result;
        for (int i = arr.size() - 1; i >= 0; i--) {
            int j = 0;
            while (j < i) {
                if (arr[j] == i + 1) {
                    break;
                }
                j++;
            }
            reverse(arr.begin(), arr.begin() + j + 1);
            result.push_back(j + 1);
            reverse(arr.begin(), arr.begin() + i + 1);
            result.push_back(i + 1);
        }
        return result;
    }
};