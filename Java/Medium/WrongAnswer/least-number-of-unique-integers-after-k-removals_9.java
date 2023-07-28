class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        int[] counts = new int[100001];
        for (int x : arr) {
            counts[x]++;
        }
        Arrays.sort(counts);
        int i = 0;
        while (k > 0) {
            k -= counts[i];
            i++;
        }
        return k == 0 ? counts.length - i : counts.length - i + 1;
    }
}