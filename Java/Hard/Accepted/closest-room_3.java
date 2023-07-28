class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int[] res = new int[queries.length];
        int[][] sortedRooms = new int[rooms.length][2];
        for (int i = 0; i < rooms.length; i++) {
            sortedRooms[i][0] = rooms[i][0];
            sortedRooms[i][1] = rooms[i][1];
        }
        Arrays.sort(sortedRooms, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int minDiff = Integer.MAX_VALUE;
            int minRoom = -1;
            for (int[] r : sortedRooms) {
                if (r[1] < q[1]) {
                    break;
                }
                if (minDiff > Math.abs(r[0] - q[0])) {
                    minDiff = Math.abs(r[0] - q[0]);
                    minRoom = r[0];
                } else if (minDiff == Math.abs(r[0] - q[0]) && minRoom > r[0]) {
                    minRoom = r[0];
                }
            }
            res[i] = minRoom;
        }
        return res;
    }
}