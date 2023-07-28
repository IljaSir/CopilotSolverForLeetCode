class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        c = arr[2];
        int min = 0;
        int max = 0;
        if (b - a == 1 && c - b == 1) {
            return new int[] {min, max};
        }
        if (b - a == 1 || c - b == 1 || b - a == 2 || c - b == 2) {
            min = 1;
        } else {
            min = 2;
        }
        max = c - a - 2;
        return new int[] {min, max};
    }
}