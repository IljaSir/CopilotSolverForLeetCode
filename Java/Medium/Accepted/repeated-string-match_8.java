class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length() < lenB) {
            sb.append(a);
            count++;
        }
        if(sb.toString().contains(b)) {
            return count;
        }
        sb.append(a);
        count++;
        if(sb.toString().contains(b)) {
            return count;
        }
        return -1;
    }
}