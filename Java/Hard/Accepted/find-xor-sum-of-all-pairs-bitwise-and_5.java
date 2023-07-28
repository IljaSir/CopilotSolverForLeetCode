class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        
        int x = 0, y = 0;
        for (int a : arr1) {
            x ^= a;
        }
        for (int a : arr2) {
            y ^= a;
        }
        return x & y;
    }
}