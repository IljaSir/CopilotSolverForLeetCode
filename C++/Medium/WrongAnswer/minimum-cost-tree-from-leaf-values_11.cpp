class Solution {
public:
    int mctFromLeafValues(vector<int>& arr) {
        
        int res = 0;
        while (arr.size() > 1) {
            int i = min_element(arr.begin(), arr.end()) - arr.begin();
            res += arr[i] * (i > 0 ? arr[i - 1] : 1) * (i < arr.size() - 1 ? arr[i + 1] : 1);
            arr.erase(arr.begin() + i);
        }
        return res;
    }
};