class Solution {
public:
    int countTriplets(vector<int>& arr) {
        
        int n = arr.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int xorV = arr[i];
            for (int k = i + 1; k < n; ++k) {
                xorV ^= arr[k];
                if (xorV == 0) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
};