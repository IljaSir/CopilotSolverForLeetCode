class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;
        int sBackspace = 0;
        int tBackspace = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0) {
                if (s.charAt(sIndex) == '#') {
                    sBackspace++;
                    sIndex--;
                } else if (sBackspace > 0) {
                    sBackspace--;
                    sIndex--;
                } else {
                    break;
                }
            }
            while (tIndex >= 0) {
                if (t.charAt(tIndex) == '#') {
                    tBackspace++;
                    tIndex--;
                } else if (tBackspace > 0) {
                    tBackspace--;
                    tIndex--;
                } else {
                    break;
                }
            }
            if (sIndex >= 0 && tIndex >= 0 && s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            }
            if ((sIndex >= 0) != (tIndex >= 0)) {
                return false;
            }
            sIndex--;
            tIndex--;
        }
        return true;
    }
}