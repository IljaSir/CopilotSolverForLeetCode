class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int aliceStart = Integer.parseInt(arriveAlice.substring(0, 2)) * 30 + Integer.parseInt(arriveAlice.substring(3));
        int aliceEnd = Integer.parseInt(leaveAlice.substring(0, 2)) * 30 + Integer.parseInt(leaveAlice.substring(3));
        int bobStart = Integer.parseInt(arriveBob.substring(0, 2)) * 30 + Integer.parseInt(arriveBob.substring(3));
        int bobEnd = Integer.parseInt(leaveBob.substring(0, 2)) * 30 + Integer.parseInt(leaveBob.substring(3));
        int start = Math.max(aliceStart, bobStart);
        int end = Math.min(aliceEnd, bobEnd);
        if (end < start) {
            return 0;
        }
        return end - start + 1;
    }
}