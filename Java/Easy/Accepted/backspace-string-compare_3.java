class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;
        int sBackspace = 0;
        int tBackspace = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0 && (s.charAt(sIndex) == '#' || sBackspace > 0)) {
                if (s.charAt(sIndex) == '#') {
                    sBackspace++;
                } else {
                    sBackspace--;
                }
                sIndex--;
            }
            while (tIndex >= 0 && (t.charAt(tIndex) == '#' || tBackspace > 0)) {
                if (t.charAt(tIndex) == '#') {
                    tBackspace++;
                } else {
                    tBackspace--;
                }
                tIndex--;
            }
            if (sIndex < 0 && tIndex < 0) {
                return true;
            } else if (sIndex < 0 || tIndex < 0) {
                return false;
            } else if (s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            }
            sIndex--;
            tIndex--;
        }
        return true;
    }
}