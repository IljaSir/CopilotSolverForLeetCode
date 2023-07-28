class Solution {
public:
    int minimumOneBitOperations(int n) {
        
        return n ? (n ^ (n >> 1)) : 0;
    }
};