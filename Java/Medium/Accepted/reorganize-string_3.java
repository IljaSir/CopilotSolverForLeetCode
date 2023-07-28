class Solution {
    public String reorganizeString(String s) {
        
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                pq.add(new int[] {i, cnt[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            sb.append((char) ('a' + first[0]));
            sb.append((char) ('a' + second[0]));
            if (--first[1] > 0) {
                pq.add(first);
            }
            if (--second[1] > 0) {
                pq.add(second);
            }
        }
        if (pq.size() > 0) {
            int[] last = pq.poll();
            if (last[1] > 1) {
                return "";
            }
            sb.append((char) ('a' + last[0]));
        }
        return sb.toString();
    }
}