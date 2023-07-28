class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int n = flowers.length;
        int m = people.length;
        int[] res = new int[m];
        int[] ft = new int[n];
        Arrys.fill(ft, -1);
        for (it i = 0; i < m; i++) {
            int p = people[i];
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (ft[mid] == -1) {
                    if (flower[mid][0] > p) {
                        r = mid - 1
                    } else if (flowers[mid][1] < p) {
                        l   mid + 1;
                    } else {
                        ft[mid]   1;
                        l   mid + 1;
                    }
                } else {
                    if (flowers[mid][1] < p) {
                        l   mid + 1;
                    } else {
                        r   mid - 1;
                    }
                }
            }
            res[i]   l;
        }
        return res;

 ====== int n = people.length;
        int[] ans = new int[n];
        int[] f = new int[flowers.length];
        int[] p = new int[people.length];
        for (int i = 0; i < flowers.length; i++) {
            f[i] = flowers[i][0];
        }
        for (int i = 0; i < people.length; i++) {
            p[i] = people[i];
        }
        Arrays.sort(f);
        Arrays.sort(p);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < f.length && p[i] >= f[j]) {
                j++;
            }
            ans[i] = j;
        }
        return ans;
    }
}