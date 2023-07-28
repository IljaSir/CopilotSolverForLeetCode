class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int[] alice = new int[2];
        int[] bob = new int[2];
        alice[0] = Integer.parseInt(arriveAlice.substring(0, 2));
        alice[1] = Integer.parseInt(arriveAlice.substring(3, 5));
        bob[0] = Integer.parseInt(arriveBob.substring(0, 2));
        bob[1] = Integer.parseInt(arriveBob.substring(3, 5));
        int[] leaveA = new int[2];
        int[] leaveB = new int[2];
        leaveA[0] = Integer.parseInt(leaveAlice.substring(0, 2));
        leaveA[1] = Integer.parseInt(leaveAlice.substring(3, 5));
        leaveB[0] = Integer.parseInt(leaveBob.substring(0, 2));
        leaveB[1] = Integer.parseInt(leaveBob.substring(3, 5));
        int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        while (alice[0] < leaveA[0] || alice[1] < leaveA[1]) {
            if (alice[0] == bob[0] && alice[1] == bob[1]) {
                res++;
            }
            alice[1]++;
            if (alice[1] > days[alice[0]]) {
                alice[0]++;
                alice[1] = 1;
            }
        }
        while (bob[0] < leaveB[0] || bob[1] < leaveB[1]) {
            if (alice[0] == bob[0] && alice[1] == bob[1]) {
                res++;
            }
            bob[1]++;
            if (bob[1] > days[bob[0]]) {
                bob[0]++;
                bob[1] = 1;
            }
        }
        return res;
    }
}