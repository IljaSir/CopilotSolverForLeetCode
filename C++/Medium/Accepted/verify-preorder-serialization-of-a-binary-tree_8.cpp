class Solution {
public:
    bool isValidSerialization(string preorder) {
        
        int n = preorder.size();
        if (!n) return false;
        int i = 0;
        int diff = 1;
        while (i < n) {
            if (diff == 0) return false;
            if (preorder[i] == ',') {
                i++;
                continue;
            }
            if (preorder[i] == '#') {
                diff--;
                i++;
                continue;
            }
            while (i < n && preorder[i] != ',') {
                i++;
            }
            diff++;
        }
        return diff == 0;
    }
};