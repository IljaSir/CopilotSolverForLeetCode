class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        int[] count = new int[100001];
        for (int n : arr) {
            count[n]++;
        }
        Arrays.sort(count);
        int i = 0;
        while (k > 0) {
            k -= count[i++];
        }
        return k == 0 ? 100000 - i : 100000 - i + 1;
    }
}