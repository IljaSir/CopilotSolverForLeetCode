class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        vector<int> res;
        int n = arr.size();
        sort(arr.begin(), arr.end());
        int m = arr[(n - 1) / 2];
        int i = 0, j = n - 1;
        while (k--) {
            if (abs(arr[i] - m) > abs(arr[j] - m)) {
                res.push_back(arr[i++]);
            } else {
                res.push_back(arr[j--]);
            }
        }
        return res;
    }
};