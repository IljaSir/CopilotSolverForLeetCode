class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] result = new int[2];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int round = 0;
        while (n > 1) {
            round++;
            int[] tmp = new int[n / 2];
            int index = 0;
            for (int i = 0; i < n / 2; i++) {
                if (arr[i] == firstPlayer && arr[n - 1 - i] == secondPlayer || arr[i] == secondPlayer && arr[n - 1 - i] == firstPlayer) {
                    result[0] = round;
                    result[1] = round;
                } else if (arr[i] == firstPlayer || arr[i] == secondPlayer) {
                    tmp[index++] = arr[i];
                } else if (arr[n - 1 - i] == firstPlayer || arr[n - 1 - i] == secondPlayer) {
                    tmp[index++] = arr[n - 1 - i];
                }
            }
            if (n % 2 == 1) {
                tmp[index++] = arr[n / 2];
            }
            arr = tmp;
            n = n / 2;
        }
        if (result[0] == 0) {
            result[0] = 1;
        }
        return result;
    }
}