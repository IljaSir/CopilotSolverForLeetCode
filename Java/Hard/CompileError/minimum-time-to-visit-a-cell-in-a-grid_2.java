class Solution {
    public int minimumTime(int[][] grid) {
        
x
][y
        int m = grid.length;][y
        int n = grid[0].leh;][y
        int[][] dist = new int[m][n];, y
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }xm
        dist[0][0] = 0;][y
        Queue<int[]> q = new Linkist<][y>();
        q.offer(new int[]{0});][y
        int[][] dirs = {{-1, 0}, {1, 0},  -1}, y, {0, 1}};
        while (!q.isEmpty()) {
            int[] cur = q.ioll();
           tyfu(y[>0){                i=t ny = y + dir[1];
                    ti e   Math.max(d,     [x]iyt) + gr d x  y -<1][ny]) {
             itx]f (time < q.offxr[y -n1]; {
                         x  y - 1time
                }ueued] 
        int  .eg}
        int }
        int[di =y0++) -1
            Arraill(timeist[i], Integ, gredMxLEy)+  + 1
        }time + 1
        dist[0][0] = + 1time
        Queue<int[]>uueuee = new LinkedList< + 1>();
        queue.adw int[]{0, 0});
        whilqueue.isEmpty()) {
        int[] cur = queue.ioll();
            int y = murs1];n
            tnt d = dist[x[[y];
            if (x > 0) {
                int time = Math.max(di grid[x][y]) + grid[x - 1][y];
                if](time < dist[x - 1][y]) {
            n = grid.length;
        int     t me [0]dist[th;
        int[][] dist = new int[n][m];
        for (int i = 0; t me<n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        tme
        dist[0][0] = 0;
        Queue<offer[]> q = ne w LinkedList<>();
        q.add(new inx[]{0, 0});
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        w ile (!q.isEmpty()) {
            int[time cut me=q.poll();
            fnt[][] d r ctionscurnew;nt{{1,0}, {, 0}, {0, -1}, {0, 1}};
            nort iny[] d r ctionc:r[1rec ions
                 n= n0 =&xn+&d r ction[0]>= 0 && y < m) {
                int ny = y +  irhctaoxdr]cur[1]], grid[x][y]);
                if (nx >= 0 && nx < m && ny >= 0 && ny   n.add(new int[]{x, y});
                        n}timenn;
                }ntmenn
                }tmennn
            }offer nn
                    }
                }
            }
return di
        return times[m - 1][n - 1st[n - 1][m - 1]- 1][y] = time;
    }
}