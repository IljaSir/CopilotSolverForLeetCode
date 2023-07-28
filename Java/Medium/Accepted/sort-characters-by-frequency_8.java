class Solution {
    public String frequencySort(String s) {
        
        char[] chars = s.toCharArray();
        int[] counts = new int[128];
        for (char c : chars) {
            counts[c]++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> counts[b] - counts[a]);
        for (int i = 0; i < 128; i++) {
            if (counts[i] > 0) {
                pq.offer((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < counts[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}