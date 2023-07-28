class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int length = rooms.length;
        int[] result = new int[queries.length];
        int[] index = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(index, (a, b) -> queries[b][1] - queries[a][1]);
        Arrays.sort(queries, (a, b) -> b[1] - a[1]);
        TreeSet<Integer> set = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            while (j < rooms.length && rooms[j][1] >= queries[i][1]) {
                set.add(rooms[j++][0]);
            }
            Integer low = set.floor(queries[i][0]);
            Integer high = set.ceiling(queries[i][0]);
            if (low == null && high == null) {
                result[index[i]] = -1;
            } else if (low == null) {
                result[index[i]] = high;
            } else if (high == null) {
                result[index[i]] = low;
            } else {
                result[index[i]] = Math.abs(queries[i][0] - low) <= Math.abs(queries[i][0] - high) ? low : high;
            }
        }
        return result;
    }
}