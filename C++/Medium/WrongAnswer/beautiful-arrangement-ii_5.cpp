class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> result(n, 0);
        int i = 0, j = n - 1;
        while (i <= j) {
            if (k > 1) {
                result[i++] = k-- % 2 ? n - k : k + 1;
            } else {
                result[i++] = k-- % 2 ? j-- : i++;
            }
        }
        return result;
    }
};