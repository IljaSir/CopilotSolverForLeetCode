class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        int[] freq = new int[100001];
        for (int i : arr) {
            freq[i]++;
        }
        Arrays.sort(freq);
        int i = 0;
        while (k > 0) {
            k -= freq[i];
            i++;
        }
        if (k < 0) {
            i--;
        }
        return 100001 - i;
    }
}