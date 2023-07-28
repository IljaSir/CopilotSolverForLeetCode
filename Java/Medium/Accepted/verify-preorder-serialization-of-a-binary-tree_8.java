class Solution {
    public boolean isValidSerialization(String preorder) {
        
        int n = preorder.length();
        if (n == 0) return false;
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) return false;
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++;
            }
        }
        return slots == 0;
    }
}