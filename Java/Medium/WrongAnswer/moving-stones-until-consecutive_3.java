class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int min = 0;
        if (arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2) {
            min = 1;
        } else if (arr[1] - arr[0] > 2 && arr[2] - arr[1] > 2) {
            min = 2;
        }
        int max = arr[2] - arr[0] - 2;
        return new int[]{min, max};
    }
}