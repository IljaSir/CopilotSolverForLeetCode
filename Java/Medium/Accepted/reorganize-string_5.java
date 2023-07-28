class Solution {
    public String reorganizeString(String s) {
        
        int[] count = new int[26];
        int max = 0;
        char[] sc = s.toCharArray();
        for (char c : sc) {
            count[c - 'a']++;
            max = Math.max(max, count[c - 'a']);
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                pq.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char c1 = pq.poll();
            char c2 = pq.poll();
            sb.append(c1);
            sb.append(c2);
            count[c1 - 'a']--;
            count[c2 - 'a']--;
            if (count[c1 - 'a'] > 0) {
                pq.add(c1);
            }
            if (count[c2 - 'a'] > 0) {
                pq.add(c2);
            }
        }
        if (pq.size() > 0) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}