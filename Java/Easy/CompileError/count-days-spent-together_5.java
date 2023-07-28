class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int[] days = new int[32];
        int[] months = new int[13];
        months[1] = 31;
        months[2] = 28;
        months[3] = 31;
        months[4] = 30;
        months[5] = 31;
        months[6] = 30;
        months[7] = 31;
        months[8] = 31;
        months[9] = 30;
        months[10] = 31;
        months[11] = 30;
        months[12] = 31;
        int m1 = Integer.parseInt(arriveAlice.substring(0, 2));
        int m2 = Integer.parseInt(leaveAlice.substring(0, 2));
        int d1 = Integer.parseInt(arriveAlice.substring(3));
        int d2 = Integer.parseInt(leaveAlice.substring(3));
        for (int i = m1; i <= m2; i++) {
            if (i == m1) {
                for (int j = d1; j <= days[i]; j++) {
                    days[j] = 1;
                }
            } else if (i == m2) {
                for (int j = 1; j <= d2; j++) {
                    days[j] = 1;
                }
            } else {
                for (int j = 1; j <= days[i]; j++) {
                    days[j] = 1;
                }
            }
        }
        m1 = Integer.parseInt(arriveBob.substring(0, 2));
        m2 = Integer.parseInt(leaveBob.substring(0, 2));
        d1 = Integer.parseInt(arriveBob.substring(3));
        d2 = Integer.parseInt(leaveBob.substring(3));
        for (int i = m1; i <= m2; i++) {
            if (i == m1) {
                for (int j = d1; j <= days[i]; j++) {
                    days[j] += 1;
                }
            } else if (i == m2) {
                for (int j = 1; j <= d2; j++) {
                    days[j] += 1;
                }
            } else {
                for (int j = 1; j <= days[i]; j++) {
                    days[j] += 1;
                }
            }
    }
}