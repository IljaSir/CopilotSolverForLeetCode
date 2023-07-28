class Solution {
    public String modifyString(String s) {
        
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if ((i == 0 || a[i - 1] != c) && (i == a.length - 1 || a[i + 1] != c)) {
                        a[i] = c;
                        break;
                    }
                }
            }
        }
        return new String(a);
    }
}
    }
}