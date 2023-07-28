class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        
        int ans = 0;
        for(int i=0; i<32; i++) {
            int mask = 1 << i;
            if((left & mask) == (right & mask)) {
                ans |= left & mask;
            } else {
                break;
            }
        }
        return ans;
    }
};