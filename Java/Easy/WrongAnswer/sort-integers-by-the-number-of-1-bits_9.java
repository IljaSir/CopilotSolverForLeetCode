class Solution {
    public int[] sortByBits(int[] arr) {
        
        int[] sorted = new int[arr.length];
        int[] count = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            int c = 0;
            while (n > 0) {
                if (n % 2 == 1) {
                    c++;
                }
                n = n / 2;
            }
            count[arr[i]] = c;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = 10001;
            for (int j = 0; j < arr.length; j++) {
                if (count[arr[j]] < min) {
                    min = count[arr[j]];
                }
            }
            for (int j = 0; j < arr.length; j++) {
                if (count[arr[j]] == min) {
                    sorted[i] = arr[j];
                    count[arr[j]] = 10001;
                    break;
                }
            }
        }
        return sorted;
    }
}