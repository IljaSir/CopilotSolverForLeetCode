class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, s.length());
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            firstIndex[c - 'a'] = Math.min(firstIndex[c - 'a'], i);
            lastIndex[c - 'a'] = Math.max(lastIndex[c - 'a'], i);
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (firstIndex[i] < lastIndex[i]) {
                intervals.add(new int[]{firstIndex[i], lastIndex[i]});
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
            int left = interval[0], right = interval[1];
            int[] count = new int[26];
            for (int i = left; i <= right; i++) {
                count[s.charAt(i) - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0 && (firstIndex[i] < left || lastIndex[i] > right)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans.add(s.substring(left, right + 1));
            }
        }
        return ans;
    }
}