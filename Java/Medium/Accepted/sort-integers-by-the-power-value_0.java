class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[][] arr = new int[hi - lo + 1][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = lo + i;
            arr[i][1] = getPower(lo + i);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        return arr[k - 1][0];
    }

    public int getPower(int num) {
        int count = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
        }
        return count;
    }
}