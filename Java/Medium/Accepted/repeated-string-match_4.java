class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) {
            sb.append(a);
            i++;
        }
        if (sb.toString().contains(b)) {
            return i;
        }
        if (sb.append(a).toString().contains(b)) {
            return i + 1;
        }
        return -1;
    }
}