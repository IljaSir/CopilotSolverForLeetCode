class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        
        int i = 0;
        while (i < bits.size()) {
            if (i == bits.size() - 1) {
                return true;
            }
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return false;
    }
};