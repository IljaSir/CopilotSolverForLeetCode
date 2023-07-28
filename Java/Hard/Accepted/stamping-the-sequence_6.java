class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        List<Integer> result = new ArrayList<>();
        char[] t = target.toCharArray();
        char[] s = stamp.toCharArray();
        int n = t.length;
        boolean[] done = new boolean[n];
        int count = 0;
        while (count < n) {
            boolean found = false;
            for (int i = 0; i <= n - s.length; i++) {
                if (!done[i] && canReplace(t, s, i)) {
                    found = true;
                    done[i] = true;
                    count += replace(t, i, i + s.length);
                    result.add(i);
                }
            }
            if (!found) {
                return new int[0];
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean canReplace(char[] t, char[] s, int start) {
        for (int i = 0; i < s.length; i++) {
            if (t[i + start] != '?' && t[i + start] != s[i]) {
                return false;
            }
        }
        return true;
    }

    private int replace(char[] t, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (t[i] != '?') {
                t[i] = '?';
                count++;
            }
        }
        return count;
    }
}