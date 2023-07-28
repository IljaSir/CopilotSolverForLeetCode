class Solution {
    public int kSimilarity(String s1, String s2) {
        
        if(s1.equals(s2)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(s1);
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add(s1);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                int j = 0;
                while(cur.charAt(j) == s2.charAt(j)) j++;
                for(int k = j + 1; k < cur.length(); k++) {
                    if(cur.charAt(k) == s2.charAt(k) || cur.charAt(k) != s2.charAt(j)) continue;
                    String next = swap(cur, j, k);
                    if(next.equals(s2)) return step + 1;
                    if(visited.add(next)) q.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
}