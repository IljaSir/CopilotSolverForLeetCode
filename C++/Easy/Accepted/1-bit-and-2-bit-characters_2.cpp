class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        
        int i = 0;
        int n = bits.size();
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }
};