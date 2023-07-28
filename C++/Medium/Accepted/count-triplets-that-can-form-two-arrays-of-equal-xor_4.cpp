class Solution {
public:
    int countTriplets(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> xorSum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            xorSum[i + 1] = xorSum[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (xorSum[i] == xorSum[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
};