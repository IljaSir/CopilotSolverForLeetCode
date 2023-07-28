class Solution {
    public String modifyString(String s) {
        
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '?') {
                char left = i == 0 ? ' ' : chs[i - 1];
                char right = i == chs.length - 1 ? ' ' : chs[i + 1];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != left && c != right) {
                        chs[i] = c;
                        break;
                    }
                }
            }
        }
        return new String(chs);
    }
}