class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        
        int a = 0, b = 0;
        for (int x : arr1) a ^= x;
        for (int x : arr2) b ^= x;
        return a & b;
    }
}