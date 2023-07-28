class Solution {
public:
    bool isValidSerialization(string preorder) {
        
        int n = preorder.size();
        int i = 0;
        int cnt = 0;
        while (i < n) {
            while (i < n && preorder[i] == ',') ++i;
            if (i >= n) break;
            if (preorder[i] == '#') {
                --cnt;
                if (cnt < 0) return false;
            } else {
                ++cnt;
                while (i < n && preorder[i] != ',') ++i;
            }
        }
        return cnt == -1;
    }
};