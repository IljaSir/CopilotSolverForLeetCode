class Solution {
    public String countAndSay(int n) {
        
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < prev.length()) {
            int j = i + 1;
            while (j < prev.length() && prev.charAt(j) == prev.charAt(i)) j++;
            sb.append(j - i).append(prev.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}