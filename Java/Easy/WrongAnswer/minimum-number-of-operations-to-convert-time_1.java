class Solution {
    public int convertTime(String current, String correct) {
        
        String[] c = current.split(":");
        String[] r = correct.split(":");
        int ch = Integer.parseInt(c[0]);
        int cm = Integer.parseInt(c[1]);
        int rh = Integer.parseInt(r[0]);
        int rm = Integer.parseInt(r[1]);
        int m = 0;
        if (rm >= cm) {
            m = rm - cm;
        } else {
            m = 60 + rm - cm;
            rh--;
        }
        int h = 0;
        if (rh >= ch) {
            h = rh - ch;
        } else {
            h = 24 + rh - ch;
        }
        int[] a = new int[]{1, 5, 15, 60};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int t = 0;
            if (h > 0) {
                t += h * 60 / a[i];
            }
            if (m > 0) {
                t += m / a[i];
            }
            min = Math.min(min, t);
        }
        return min;
    }
}