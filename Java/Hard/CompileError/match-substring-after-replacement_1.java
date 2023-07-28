class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = sub.length();
        while (i < n && j < m) {
            if (s.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                boolean found = false;
                for (int k = 0; k < mappings.length; k++) {
                    if (s.charAt(i) == mappings[k][0] && sub.charAt(j) == mappings[k][1]) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return j == m;
    }
}
    }
}