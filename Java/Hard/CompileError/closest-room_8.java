class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int n = rooms.length;
        int m = queries.length;
        int[] res = new int[m];
        Arrays.fill(res, -1);
        Room[] roomArr = new Room[n];
        for (int i = 0; i < n; i++) {
            roomArr[i] = new Room(rooms[i][0], rooms[i][1]);
        }
        Arrays.sort(roomArr, (a, b) -> b.size - a.size);
        Query[] queryArr = new Query[m];
        for (int i = 0; i < m; i++) {
            queryArr[i] = new Query(queries[i][0], queries[i][1], i);
        }
        Arrays.sort(queryArr, (a, b) -> b.minSize - a.minSize);
        TreeSet<Integer> set = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && roomArr[j].size >= queryArr[i].minSize) {
                set.add(roomArr[j].id);
                j++;
            }
            if (set.isEmpty()) {
                continue;
            }
            Integer left = set.floor(queryArr[i].preferred);
            Integer right = set.ceiling(queryArr[i].preferred);
            if (left != null && right != null) {
                res[queryArr[i].index] = Math.abs(left - queryArr[i].preferred) <= Math.abs(right - queryArr[i].preferred) ? left : right;
            } else if (left != null) {
                res[queryArr[i].index] = left;
            } else if (right != null) {
                res[queryArr[i].index] = right;
            }
        }
        return res;
    }
}
    }
}