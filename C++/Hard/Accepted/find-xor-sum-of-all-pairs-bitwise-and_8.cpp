class Solution {
public:
    int getXORSum(vector<int>& arr1, vector<int>& arr2) {
        
        int x1=0, x2=0;
        for (int i=0; i<arr1.size(); i++) x1 ^= arr1[i];
        for (int i=0; i<arr2.size(); i++) x2 ^= arr2[i];
        return x1 & x2;
    }
};