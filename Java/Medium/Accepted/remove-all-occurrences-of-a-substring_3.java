class Solution {
    public String removeOccurrences(String s, String part) {
        
        int len = part.length();
        while (s.contains(part)) {
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + len);
        }
        return s;
    }
}