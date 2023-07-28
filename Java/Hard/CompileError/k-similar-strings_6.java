class Solution {
    public int kSimilarity(String s1, String s2) {
        
        if (s1.equals(s2)) {
            return 0;
        }
        int n = s1.length();
        int[] s1Array = new int[n];
        int[] s2Array = new int[n];
        for (int i = 0; i < n; i++) {
            s1Array[i] = s1.charAt(i) - 'a';
            s2Array[i] = s2.charAt(i) - 'a';
        }
        int[] count = new int[6];
        for (int i = 0; i < n; i++) {
            count[s1Array[i]]++;
            count[s2Array[i]]--;
        }
        for (int i = 0; i < 6; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(s1Array);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (Arrays.equals(cur, s2Array)) {
                    return step;
                }
                int j = 0;
                while (cur[j] == s2Array[j]) {
                    j++;
                }
                for (int k = j + 1; k < n; k++) {
                    if (cur[k] == s2Array[k] || cur[k] != s2Array[j]) {
                        continue;
                    }
                    swap(cur, j, k);
                    queue.offer(cur.clone());
                    swap(cur, j, k);
                }
            }
            step++;
        }
        return -1;
    }
}