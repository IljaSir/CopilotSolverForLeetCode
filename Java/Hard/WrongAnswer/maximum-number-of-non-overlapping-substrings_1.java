class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, s.length());
        Arrays.fill(right, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = Math.max(right[c], i);
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (left[i] <= right[i]) {
                intervals.add(new int[] {left[i], right[i]});
            }
        }
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int[] interval : merged) {
            int l = interval[0], r = interval[1];
            boolean[] vis = new boolean[26];
            boolean flag = true;
            for (int i = l; i <= r; i++) {
                int c = s.charAt(i) - 'a';
                if (vis[c]) {
                    continue;
                }
                vis[c] = true;
                if (left[c] < l || right[c] > r) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(s.substring(l, r + 1));
            }
        }
        return ans;
    }
}