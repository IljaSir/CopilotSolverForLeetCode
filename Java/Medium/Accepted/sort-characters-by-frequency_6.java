class Solution {
    public String frequencySort(String s) {
        
        int[] count = new int[256];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                pq.offer((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < count[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}