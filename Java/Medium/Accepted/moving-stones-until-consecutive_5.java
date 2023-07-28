class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int min = 0;
        int max = 0;
        if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1) {
            min = 0;
            max = 0;
        } else if (arr[1] - arr[0] == 1 || arr[2] - arr[1] == 1) {
            min = 1;
            max = arr[2] - arr[0] - 2;
        } else if (arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2) {
            min = 1;
            max = arr[2] - arr[0] - 2;
        } else {
            min = 2;
            max = arr[2] - arr[0] - 2;
        }
        return new int[]{min, max};
    }
}