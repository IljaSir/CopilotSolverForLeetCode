class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int n = target.length();
        char[] t = target.toCharArray();
        List<Integer> ans = new ArrayList<>();
        boolean[] done = new boolean[n];
        int doneCount = 0;
        while (doneCount < n) {
            boolean stamped = false;
            for (int i = 0; i <= n - stamp.length(); ++i) {
                if (!done[i] && canStamp(stamp, t, i)) {
                    stamp(stamp, t, i, done);
                    doneCount += stamp.length();
                    stamped = true;
                    ans.add(i);
                }
            }
            if (!stamped) return new int[0];
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
    public boolean canStamp(String stamp, char[] t, int i) {
        for (int j = 0; j < stamp.length(); ++j) {
            if (t[i + j] != '?' && t[i + j] != stamp.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public void stamp(String stamp, char[] t, int i, boolean[] done) {
        for (int j = 0; j < stamp.length(); ++j) {
            t[i + j] = '?';
            done[i + j] = true;
        }
    }
}