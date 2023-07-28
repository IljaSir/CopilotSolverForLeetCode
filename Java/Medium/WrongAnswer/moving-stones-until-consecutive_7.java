class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int min = 0, max = 0;
        if (arr[1] - arr[0] > 1) {
            min++;
            max += arr[1] - arr[0] - 1;
        }
        if (arr[2] - arr[1] > 1) {
            min++;
            max += arr[2] - arr[1] - 1;
        }
        if (min == 2 && max == 2) {
            min = 1;
        }
        return new int[]{min, max};
    }
}