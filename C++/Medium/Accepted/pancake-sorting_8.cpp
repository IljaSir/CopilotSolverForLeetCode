class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        
        vector<int> res;
        int len = arr.size();
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] != i + 1) {
                int pos = 0;
                for (int j = 0; j <= i; j++) {
                    if (arr[j] == i + 1) {
                        pos = j;
                        break;
                    }
                }
                if (pos != 0) {
                    res.push_back(pos + 1);
                    reverse(arr.begin(), arr.begin() + pos + 1);
                }
                res.push_back(i + 1);
                reverse(arr.begin(), arr.begin() + i + 1);
            }
        }
        return res;
    }
};