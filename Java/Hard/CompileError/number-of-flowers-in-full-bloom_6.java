class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int n = flowers;
        int m = people.length;
        int[ res = new int[m]
        for ( ft = newiint[n];
        Arrays.fill(ft, -1);
        for (int i = 0; i < m; i++) {
            int p = people[i];
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (ft[mid] == -1) {
                    if (flowers[mid][0] > p) {
                        r = mid - 1;
                    } else if (flowers[mid][1] < p) {
                        l = mid + 1;
                    } else {
                        ft[mid] = 1;
                        l = mid + 1;
                    }
                } else {
                    if (flowers[mid][1] < p) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            res[i] = l;
        }
        return res;
    }
}