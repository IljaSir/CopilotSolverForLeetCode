class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] repeat = new int[26];
        Arrays.fill(repeat, 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (repeat[idx] > 0) {
                sb.append(c);
                repeat[idx]--;
            } else {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) <= c) {
                    char last = sb.charAt(sb.length() - 1);
                    if (count[last - 'a'] > repeatLimit) {
                        sb.deleteCharAt(sb.length() - 1);
                        count[last - 'a']--;
                        repeat[last - 'a']++;
                    } else {
                        break;
                    }
                }
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) < c) {
                    sb.append(c);
                    repeat[idx]--;
                }
            }
        }
        return sb.toString();
    }
}