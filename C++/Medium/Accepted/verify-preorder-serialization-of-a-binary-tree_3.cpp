class Solution {
public:
    bool isValidSerialization(string preorder) {
        
        int n = preorder.size();
        int i = 0;
        int cnt = 1;
        while (i < n) {
            if (cnt == 0) return false;
            if (preorder[i] == '#') {
                cnt--;
                i++;
            } else {
                while (i < n && preorder[i] != ',') i++;
                cnt++;
            }
            if (i < n) i++;
        }
        return cnt == 0;
    }
};