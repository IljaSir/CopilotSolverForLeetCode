class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, s.length());
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] <= last[i]) {
                intervals.add(new int[]{first[i], last[i]});
            }
        }
        intervals.sort((a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        int[] rightmost = new int[s.length()];
        int r = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i > r) {
                r = merged.get(i)[1];
            }
            rightmost[i] = r;
        }
        List<String> ans = new ArrayList<>();
        int l = 0;
        r = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > r) {
                l = i;
                r = rightmost[i];
                ans.add(s.substring(l, r + 1));
            } else if (rightmost[i] > r) {
                r = rightmost[i];
                ans.set(ans.size() - 1, s.substring(l, r + 1));
            }
        }
        return ans;
    }
}