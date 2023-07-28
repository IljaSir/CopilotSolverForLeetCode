class Solution {
public:
    int countTriplets(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> pre(n + 1);
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] ^ arr[i];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (pre[i] == pre[k + 1]) res += k - i;
            }
        }
        return res;
    }
};