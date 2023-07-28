class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> res;
        for (int i = arr.size(); i > 0; --i) {
            int j = 0;
            for (; j < i; ++j)
                if (arr[j] == i) break;
            res.push_back(j + 1);
            res.push_back(i);
            reverse(arr.begin(), arr.begin() + j + 1);
            reverse(arr.begin(), arr.begin() + i);
        }
        return res;
    }
};