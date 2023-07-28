class Solution {
    public int minSetSize(int[] arr) {
        
        int[] count = new int[100001];
        for (int a : arr) {
            count[a]++;
        }
        Arrays.sort(count);
        int removed = 0;
        int result = 0;
        for (int i = count.length - 1; i >= 0 && removed < arr.length / 2; i--) {
            removed += count[i];
            result++;
        }
        return result;
    }
}