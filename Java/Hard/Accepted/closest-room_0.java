class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int[] ans = new int[queries.length];
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int minSize = query[1];
            int preferredId = query[0];
            int minDiff = Integer.MAX_VALUE;
            int roomId = -1;
            for (int[] room : rooms) {
                if (room[1] < minSize) {
                    break;
                }
                int diff = Math.abs(room[0] - preferredId);
                if (diff < minDiff) {
                    minDiff = diff;
                    roomId = room[0];
                } else if (diff == minDiff) {
                    roomId = Math.min(roomId, room[0]);
                }
            }
            ans[i] = roomId;
        }
        return ans;
    }
}