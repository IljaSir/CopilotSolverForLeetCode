class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        String[] a = arriveAlice.split("-");
        String[] b = leaveAlice.split("-");
        String[] c = arriveBob.split("-");
        String[] d = leaveBob.split("-");
        int[] x = new int[2];
        int[] y = new int[2];
        int[] z = new int[2];
        int[] w = new int[2];
        for (int i = 0; i < 2; i++) {
            x[i] = Integer.parseInt(a[i]);
            y[i] = Integer.parseInt(b[i]);
            z[i] = Integer.parseInt(c[i]);
            w[i] = Integer.parseInt(d[i]);
        }
        int days = 0;
        if (x[0] == z[0]) {
            if (x[1] > z[1]) {
                int temp = x[1];
                x[1] = z[1];
                z[1] = temp;
            }
            for (int i = x[1]; i <= y[1]; i++) {
                if (z[1] <= i && i <= w[1]) {
                    days++;
                }
            }
        } else {
            int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = x[0]; i <= y[0]; i++) {
                if (i == x[0]) {
                    for (int j = x[1]; j <= month[i - 1]; j++) {
                        if (z[0] <= i && i <= w[0]) {
                            if (z[1] <= j && j <= w[1]) {
                                days++;
                            }
                        }
                    }
                } else if (i == y[0]) {
                    for (int j = 1; j <= y[1]; j++) {
                        if (z[0] <= i && i <= w[0]) {
                            if (z[1] <= j && j <= w[1]) {
                                days++;
                            }
                        }
                    }
                } else {
                    for (int j = 1; j <= month[i - 1]; j++) {
                        if (z[0] <= i && i <= w[0]) {
                            if (z[1
    }
}