class Solution {
    public int kSimilarity(String s1, String s2) {
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s1);
        visited.add(s1);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(s2)) {
                    return steps;
                }
                int j = 0;
                while (j < cur.length() && cur.charAt(j) == s2.charAt(j)) {
                    j++;
                }
                for (int k = j + 1; k < cur.length(); k++) {
                    if (cur.charAt(k) == s2.charAt(k) || cur.charAt(k) != s2.charAt(j)) {
                        continue;
                    }
                    String next = swap(cur, j, k);
                    if (visited.add(next)) {
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}