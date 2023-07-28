class Solution {
public:
    int maxAbsValExpr(vector<int>& arr1, vector<int>& arr2) {
        
        int n = arr1.size();
        vector<int> x(n), y(n), z(n), w(n);
        for (int i = 0; i < n; ++i) {
            x[i] = arr1[i] + arr2[i] + i;
            y[i] = arr1[i] + arr2[i] - i;
            z[i] = arr1[i] - arr2[i] + i;
            w[i] = arr1[i] - arr2[i] - i;
        }
        return max({abs(*max_element(x.begin(), x.end()) - *min_element(x.begin(), x.end())),
                    abs(*max_element(y.begin(), y.end()) - *min_element(y.begin(), y.end())),
                    abs(*max_element(z.begin(), z.end()) - *min_element(z.begin(), z.end())),
                    abs(*max_element(w.begin(), w.end()) - *min_element(w.begin(), w.end()))});
    }
};