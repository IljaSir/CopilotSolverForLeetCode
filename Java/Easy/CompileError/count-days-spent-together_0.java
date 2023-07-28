class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int[] a = new int[]{Integer.parseInt(arriveAlice.substring(0, 2)), Integer.parseInt(arriveAlice.substring(3))};
        int[] b = new int[]{Integer.parseInt(leaveAlice.substring(0, 2)), Integer.parseInt(leaveAlice.substring(3))};
        int[] c = new int[]{Integer.parseInt(arriveBob.substring(0, 2)), Integer.parseInt(arriveBob.substring(3))};
        int[] d = new int[]{Integer.parseInt(leaveBob.substring(0, 2)), Integer.parseInt(leaveBob.substring(3))};
        int[] e = new int[]{Math.max(a[0], c[0]), Math.max(a[1], c[1])};
        int[] f = new int[]{Math.min(b[0], d[0]), Math.min(b[1], d[1])};
        if (e[0] > f[0] || (e[0] == f[0] && e[1] > f[1])) {
            return 0;
        }
        int[] g = new int[]{e[0], e[1]};
        int[] h = new int[]{f[0], f[1]};
        int[] i = new int[]{e[0], e[1]};
        int[] j = new int[]{f[0], f[1]};
        int[] k = new int[]{e[0], e[1]};
        int[] l = new int[]{f[0], f[1]};
        if (e[0] == f[0]) {
            return f[1] - e[1] + 1;
        }
        int[] m = new int[]{e[0], e[1]};
        int[] n = new int[]{f[0], f[1]};
        int[] o = new int[]{e[0], e[1]};
        int[] p = new int[]{f[0], f[1]};
        int[] q = new int[]{e[0], e[1]};
        int[] r = new int[]{f[0], f[1]};
        int[] s = new int[]{e[0], e[1]};
        int[] t = new int[]{f[0], f[1]};
        int[] u = new int[]{e[0], e[1]};
        int[] v = new int[]{f[
    }
}