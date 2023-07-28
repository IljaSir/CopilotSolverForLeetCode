class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(end, Integer.MIN_VALUE);
        for (int i = 0; i < s.length(); i++) {
            start[s.charAt(i) - 'a'] = Math.min(start[s.charAt(i) - 'a'], i);
            end[s.charAt(i) - 'a'] = Math.max(end[s.charAt(i) - 'a'], i);
        }
        int[] last = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            last[i] = end[c];
            for (int j = start[c]; j < i; j++) {
                last[j] = Math.max(last[j], last[i]);
            }
        }
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = last[i];
            String tmp = s.substring(i, j + 1);
            for (char c : tmp.toCharArray()) {
                if (start[c - 'a'] < i || end[c - 'a'] > j) {
                    i = j + 1;
                    j = -1;
                    break;
                }
            }
            if (j >= 0) {
                res.add(tmp);
                i = j + 1;
            }
        }
        return res;
    }
}