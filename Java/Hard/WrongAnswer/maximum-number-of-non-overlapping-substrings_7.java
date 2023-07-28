class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        
        List<String> result = new ArrayList<>();
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, Integer.MAX_VALUE);
        Arrays.fill(end, Integer.MIN_VALUE);
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            start[idx] = Math.min(start[idx], i);
            end[idx] = Math.max(end[idx], i);
        }
        int curStart = 0;
        int curEnd = 0;
        int curIdx = 0;
        while (curIdx < s.length()) {
            char c = s.charAt(curIdx);
            int cIdx = c - 'a';
            curStart = start[cIdx];
            curEnd = end[cIdx];
            for (int i = curStart; i < curEnd; i++) {
                char curC = s.charAt(i);
                int curCIdx = curC - 'a';
                if (start[curCIdx] < curStart) {
                    curStart = start[curCIdx];
                }
                if (end[curCIdx] > curEnd) {
                    curEnd = end[curCIdx];
                }
            }
            result.add(s.substring(curStart, curEnd + 1));
            curIdx = curEnd + 1;
        }
        return result;
    }
}