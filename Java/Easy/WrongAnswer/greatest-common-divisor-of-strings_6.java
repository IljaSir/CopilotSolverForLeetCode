class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        String s = str1.length() > str2.length() ? str1 : str2;
        String t = str1.length() > str2.length() ? str2 : str1;
        int sLen = s.length();
        int tLen = t.length();
        if(!s.startsWith(t)) return "";
        if(tLen == 0) return s;
        if(sLen % tLen != 0) return "";
        String x = s.substring(0, tLen);
        for(int i = tLen; i < sLen; i += tLen) {
            if(!s.substring(i, i + tLen).equals(x)) return "";
        }
        return x;
    }
}