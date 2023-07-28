class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int n = target.length();
        char[] s = target.toCharArray();
        char[] t = stamp.toCharArray();
        boolean[] done = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (!done[i] && match(s, t, i)) {
                    ans.add(i);
                    changed = true;
                    for (int j = i; j < i + t.length; j++) {
                        s[j] = '?';
                        done[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!done[i]) {
                return new int[0];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
    private boolean match(char[] s, char[] t, int i) {
        for (int j = 0; j < t.length; j++) {
            if (s[i + j] != '?' && s[i + j] != t[j]) {
                return false;
            }
        }
        return true;
    }
}