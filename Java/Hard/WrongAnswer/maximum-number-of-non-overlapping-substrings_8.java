class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        List<String> res = new ArrayList<>();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, s.length());
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }
        int lo = -1;
        int hi = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i == first[s.charAt(i) - 'a']) {
                int end = last[s.charAt(i) - 'a'];
                for (int j = i; j <= end; j++) {
                    end = Math.max(end, last[s.charAt(j) - 'a']);
                }
                if (i > hi) {
                    if (lo != -1) {
                        res.add(s.substring(lo, hi + 1));
                    }
                    lo = i;
                }
                hi = end;
            }
        }
        if (lo != -1) {
            res.add(s.substring(lo, hi + 1));
        }
        return res;
    }
}