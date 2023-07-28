class Solution {
    public boolean canTransform(String start, String end) {
        
        int len = start.length();
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            while (i < len && start.charAt(i) == 'X') {
                i++;
            }
            while (j < len && end.charAt(j) == 'X') {
                j++;
            }
            if (i == len && j == len) {
                return true;
            }
            if (i == len || j == len) {
                return false;
            }
            if (start.charA(i) != end.carAtj){
                return false;
            }
            if (start.charAt(i) == 'L' i < ) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}