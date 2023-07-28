class Solution {
    public int nextBeautifulNumber(int n) {
        
        int k = 0;
        int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
            k++;
        }
        int[] arr2 = Arrays.copyOf(arr, k);
        int i = 0;
        while (i < k) {
            if (arr2[i] < 9) {
                arr2[i]++;
                break;
            }
            arr2[i] = 0;
            i++;
        }
        if (i == k) {
            arr2 = Arrays.copyOf(arr2, k + 1);
            arr2[k] = 1;
        }
        int res = 0;
        for (int j = arr2.length - 1; j >= 0; j--) {
            res = res * 10 + arr2[j];
        }
        return res;
    }
}