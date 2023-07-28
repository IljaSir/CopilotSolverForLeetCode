class Solution {
public:
    int maxAbsValExpr(vector<int>& arr1, vector<int>& arr2) {
        
        int ans = 0;
        vector<int> v = {1,-1};
        for (int x : v) {
            for (int y : v) {
                int mi = INT_MAX;
                for (int i = 0; i < arr1.size(); ++i) {
                    mi = min(mi, arr1[i] * x + arr2[i] * y + i);
                    ans = max(ans, arr1[i] * x + arr2[i] * y + i - mi);
                }
            }
        }
        return ans;
    }
};