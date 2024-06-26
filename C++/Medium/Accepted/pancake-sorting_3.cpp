class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> res;
        int n = arr.size();
        for (int i = n; i > 0; i--) {
            auto it = find(arr.begin(), arr.begin() + i, i);
            int index = it - arr.begin();
            if (index == i - 1) continue;
            if (index > 0) {
                res.push_back(index + 1);
                reverse(arr.begin(), arr.begin() + index + 1);
            }
            res.push_back(i);
            reverse(arr.begin(), arr.begin() + i);
        }
        return res;
    }
};