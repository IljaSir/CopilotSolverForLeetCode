class Solution {
    public int kSimilarity(String s1, String s2) {
        
        if (s1.equals(s2)) {
            return 0;
        }
        int n = s1.length();
        int[] count = new int[6];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 6; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s1);
        visited.add(s1);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(s2)) {
                    return step;
                }
                int j = 0;
                while (j < n && cur.charAt(j) == s2.charAt(j)) {
                    j++;
                }
                for (int k = j + 1; k < n; k++) {
                    if (cur.charAt(k) == s2.charAt(k) || cur.charAt(k) != s2.charAt(j)) {
                        continue;
                    }
                    String next = swap(cur, j, k);
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}