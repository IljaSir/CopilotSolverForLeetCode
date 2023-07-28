class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> res;
        int n = arr.size();
        for (int i = n; i > 0; i--) {
            auto it = find(arr.begin(), arr.begin() + i, i);
            int j = it - arr.begin();
            if (j == i - 1) continue;
            if (j > 0) {
                res.push_back(j + 1);
                reverse(arr.begin(), arr.begin() + j + 1);
            }
            res.push_back(i);
            reverse(arr.begin(), arr.begin() + i);
        }
        return res;
    }
};