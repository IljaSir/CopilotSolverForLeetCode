class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int n = s.length();
        int m = sub.length();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return true;
                }
            } else {
                boolean match = false;
                for (int k = 0; k < mappings.length; k++) {
                    if (mappings[k][0] == sub.charAt(j)) {
                        j++;
                        match = true;
                        if (j == m) {
                            return true;
                        }
                        break;
                    }
                }
                if (!match) {
                    i++;
                }
            }
        }
        return false;
    }
}