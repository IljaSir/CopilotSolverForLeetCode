class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        
        bits.pop_back();
        int size = bits.size();
        if (size == 0) return true;
        if (bits[size - 1] == 0) return true;
        int count = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (bits[i] == 1) {
                count++;
            } else {
                break;
            }
        }
        return (count % 2 == 0);
    }
};