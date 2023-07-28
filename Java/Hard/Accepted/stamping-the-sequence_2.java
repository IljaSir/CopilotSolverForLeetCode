class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        List<Integer> list = new ArrayList<>();
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] done = new boolean[t.length];
        int count = 0;
        while (count < t.length) {
            boolean found = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!done[i] && canReplace(s, t, i)) {
                    found = true;
                    done[i] = true;
                    count += replace(t, i, s.length);
                    list.add(i);
                }
            }
            if (!found) {
                return new int[0];
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - 1 - i);
        }
        return res;
    }

    private boolean canReplace(char[] s, char[] t, int start) {
        for (int i = 0; i < s.length; i++) {
            if (t[start + i] != '?' && t[start + i] != s[i]) {
                return false;
            }
        }
        return true;
    }

    private int replace(char[] t, int start, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (t[start + i] != '?') {
                t[start + i] = '?';
                count++;
            }
        }
        return count;
    }
}