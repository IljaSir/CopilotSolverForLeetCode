class Solution {
public:
    bool isValidSerialization(string preorder) {
        
        int n = preorder.length();
        int slots = 1;
        for (int i = 0; i < n; i++) {
            if (slots == 0) return false;
            if (preorder[i] == ',') continue;
            else if (preorder[i] == '#') slots--;
            else {
                slots++;
                while (i + 1 < n && preorder[i + 1] != ',') i++;
            }
        }
        return slots == 0;
    }
};