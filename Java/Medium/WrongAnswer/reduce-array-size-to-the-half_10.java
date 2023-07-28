class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        int[] freq = new int[100001];
        for (int a : arr) {
            freq[a]++;
        }
        Arrays.sort(freq);
        int res = 0;
        for (int i = freq.length - 1; i >= 0 && n > 0; i--) {
            n -= freq[i];
            res++;
        }
        return res;
    }
}