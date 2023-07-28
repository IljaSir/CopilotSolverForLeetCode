class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        
        int n = arr.size();
        int i = 0;
        vector<int> res;
        while (res.size() < n) {
            if (arr[i] == 0) {
                res.push_back(0);
                res.push_back(0);
            } else {
                res.push_back(arr[i]);
            }
            i++;
        }
        arr = res;
    }
};