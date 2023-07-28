class Solution {
    public String reorganizeString(String s) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add((char)('a' + i));
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
            char c = pq.poll();
            if (count[c - 'a'] > 1) {
                return "";
            }
            sb.append(c);
        }
        return sb.toString();
    }
}