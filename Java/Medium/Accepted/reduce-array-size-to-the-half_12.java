class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length / 2;
        int[] freq = new int[100001];
        for (int i : arr) {
            freq[i]++;
        }
        Arrays.sort(freq);
        int sum = 0;
        int res = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            if (sum >= n) {
                break;
            }
            sum += freq[i];
            res++;
        }
        return res;
    }
}