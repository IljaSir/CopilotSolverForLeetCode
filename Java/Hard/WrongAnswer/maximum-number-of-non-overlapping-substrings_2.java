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
                intervals.add(new int[]{left[i], right[i]});
            }
        }
        intervals.sort((a, b) -> a[0] - b[0]);
        List<String> res = new ArrayList<>();
        int rightBound = -1;
        for (int i = 0; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (interval[0] > rightBound) {
                res.add(s.substring(interval[0], interval[1] + 1));
                rightBound = interval[1];
            } else {
                int start = interval[0];
                int end = Math.min(interval[1], rightBound);
                for (int j = start; j <= end; j++) {
                    int c = s.charAt(j) - 'a';
                    if (left[c] < start || right[c] > end) {
                        break;
                    }
                    if (j == end) {
                        res.add(s.substring(start, end + 1));
                        rightBound = end;
                    }
                }
            }
        }
        return res;
    }
}