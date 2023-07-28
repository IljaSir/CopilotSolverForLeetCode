class Solution {
    public String reorganizeString(String s) {
        
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                pq.add(new int[]{i, cnt[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] c1 = pq.poll();
            int[] c2 = pq.poll();
            sb.append((char)(c1[0] + 'a'));
            sb.append((char)(c2[0] + 'a'));
            c1[1]--;
            c2[1]--;
            if (c1[1] > 0) {
                pq.add(c1);
            }
            if (c2[1] > 0) {
                pq.add(c2);
            }
        }
        if (pq.size() > 0) {
            int[] c = pq.poll();
            if (c[1] > 1) {
                return "";
            }
            sb.append((char)(c[0] + 'a'));
        }
        return sb.toString();
    }
}