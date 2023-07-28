class Solution {
public:
    int getXORSum(vector<int>& arr1, vector<int>& arr2) {
        
        int a = 0, b = 0;
        for (auto x : arr1) a ^= x;
        for (auto x : arr2) b ^= x;
        return a & b;
    }
};