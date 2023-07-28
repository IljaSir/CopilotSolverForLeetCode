class Solution {
public:
    int getXORSum(vector<int>& arr1, vector<int>& arr2) {
        
        int n = arr1.size();
        int m = arr2.size();
        int x = 0, y = 0;
        for(int i = 0; i < n; i++) {
            x ^= arr1[i];
        }
        for(int i = 0; i < m; i++) {
            y ^= arr2[i];
        }
        return x & y;
    }
};