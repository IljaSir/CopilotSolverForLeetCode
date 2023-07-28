class Solution {
public:
    bool isValidSerialization(string preorder) {
        
        int n = preorder.size();
        int i = 0;
        int slot = 1;
        while (i < n) {
            if (slot == 0) return false;
            if (preorder[i] == ',') i++;
            else if (preorder[i] == '#') {
                slot--;
                i++;
            } else {
                while (i < n && preorder[i] != ',') i++;
                slot++;
            }
        }
        return slot == 0;
    }
};