class Solution {
public:
    int getXORSum(vector<int>& arr1, vector<int>& arr2) {
        
        int a = 0;
        for(int i = 0; i < arr1.size(); i++){
            a ^= arr1[i];
        }
        int b = 0;
        for(int i = 0; i < arr2.size(); i++){
            b ^= arr2[i];
        }
        return a & b;
    }
};