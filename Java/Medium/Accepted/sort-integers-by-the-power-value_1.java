class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[][] arr = new int[hi - lo + 1][2];
        int i = 0;
        for (int j = lo; j <= hi; j++) {
            arr[i][0] = j;
            arr[i][1] = getPower(j);
            i++;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        return arr[k - 1][0];
    }

    private int getPower(int n) {
        int power = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            power++;
        }
        return power;
    }
}