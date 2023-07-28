class Solution {
    public int kSimilarity(String s1, String s2) {
        
        int n = s1.length();
        // if (n == 0) return 0;
        // if (s1.equals(s2)) return 0;
        // int res = 0;
        // for (int i = 0; i < n; i++) {
        //     if (s1.charAt(i) != s2.charAt(i)) {
        //         for (int j = i + 1; j < n; j++) {
        //             if (s1.charAt(j) == s2.charAt(i)) {
        //                 s1 = swap(s1, i, j);
        //                 res++;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return res;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s1);
        visited.add(s1);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(s2)) return res;
                int k = 0;
                while (cur.charAt(k) == s2.charAt(k)) k++;
                for (int j = k + 1; j < n; j++) {
                    if (cur.charAt(j) == s2.charAt(k) && cur.charAt(j) != s2.charAt(j)) {
                        String next = swap(cur, k, j);
                        if (!visited.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
}