class Solution {
public:
    int maxAbsValExpr(vector<int>& arr1, vector<int>& arr2) {
        
        int n = arr1.size();
        vector<int> p1(n), p2(n), p3(n), p4(n);
        for (int i = 0; i < n; ++i) {
            p1[i] = arr1[i] + arr2[i] + i;
            p2[i] = arr1[i] + arr2[i] - i;
            p3[i] = arr1[i] - arr2[i] + i;
            p4[i] = arr1[i] - arr2[i] - i;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, p1[i] - *min_element(p1.begin(), p1.end()));
            ans = max(ans, p2[i] - *min_element(p2.begin(), p2.end()));
            ans = max(ans, p3[i] - *min_element(p3.begin(), p3.end()));
            ans = max(ans, p4[i] - *min_element(p4.begin(), p4.end()));
        }
        return ans;
    }
};