class Solution {
public:
    vector<int> getStrongest(vector<int>& arr, int k) {
        
        int n = arr.size();
        int m = arr[n/2];
        sort(arr.begin(), arr.end(), [m](int a, int b) {
            return abs(a-m) == abs(b-m) ? (a > b) : (abs(a-m) > abs(b-m));
        });
        return {arr.begin(), arr.begin()+k};
    }
};