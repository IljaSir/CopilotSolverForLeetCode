class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int n = rooms.length;
        int k = queries.length;
        int[] ans = new int[k];
        Integer[] qid = new Integer[k];
        for (int i = 0; i < k; i++) {
            qid[i] = i;
        }
        Arrays.sort(qid, (a, b) -> {
            return queries[a][1] - queries[b][1];
        });
        Arrays.sort(rooms, (a, b) -> {
            return b[1] - a[1];
        });
        TreeSet<Integer> s = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n && rooms[j][1] >= queries[qid[i]][1]) {
                s.add(rooms[j][0]);
                j++;
            }
            if (s.size() == 0) {
                ans[qid[i]] = -1;
            } else {
                int id = queries[qid[i]][0];
                Integer left = s.floor(id);
                Integer right = s.ceiling(id);
                if (left == null) {
                    ans[qid[i]] = right;
                } else if (right == null) {
                    ans[qid[i]] = left;
                } else {
                    ans[qid[i]] = (id - left <= right - id) ? left : right;
                }
            }
        }
        return ans;
    }
}