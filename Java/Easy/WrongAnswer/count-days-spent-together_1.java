class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int[] start = {Integer.parseInt(arriveAlice.substring(0, 2)), Integer.parseInt(arriveAlice.substring(3, 5))};
        int[] end = {Integer.parseInt(leaveAlice.substring(0, 2)), Integer.parseInt(leaveAlice.substring(3, 5))};
        int[] start2 = {Integer.parseInt(arriveBob.substring(0, 2)), Integer.parseInt(arriveBob.substring(3, 5))};
        int[] end2 = {Integer.parseInt(leaveBob.substring(0, 2)), Integer.parseInt(leaveBob.substring(3, 5))};
        int[] start3 = {Math.max(start[0], start2[0]), Math.max(start[1], start2[1])};
        int[] end3 = {Math.min(end[0], end2[0]), Math.min(end[1], end2[1])};
        if (start3[0] > end3[0] || (start3[0] == end3[0] && start3[1] > end3[1])) {
            return 0;
        }
        int result = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = start3[0]; i <= end3[0]; i++) {
            if (i == start3[0] && i == end3[0]) {
                result += end3[1] - start3[1] + 1;
            } else if (i == start3[0]) {
                result += days[i - 1] - start3[1] + 1;
            } else if (i == end3[0]) {
                result += end3[1];
            } else {
                result += days[i - 1];
            }
        }
        return result;
    }
}