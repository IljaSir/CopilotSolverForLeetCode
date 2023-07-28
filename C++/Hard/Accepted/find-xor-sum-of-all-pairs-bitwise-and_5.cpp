class Solution {
public:
    int getXORSum(vector<int>& arr1, vector<int>& arr2) {
        
        int a1 = 0;
        for (auto a : arr1) a1 ^= a;
        int a2 = 0;
        for (auto a : arr2) a2 ^= a;
        return a1 & a2;
    }
};