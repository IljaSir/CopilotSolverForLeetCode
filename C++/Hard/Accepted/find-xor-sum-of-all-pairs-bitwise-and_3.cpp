class Solution {
public:
    int getXORSum(vector<int>& arr1, vector<int>& arr2) {
        
        int x = 0;
        for (int i : arr1) {
            x ^= i;
        }
        int y = 0;
        for (int i : arr2) {
            y ^= i;
        }
        return x & y;
    }
};