class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        
        int x1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            x1 ^= arr1[i];
        }
        int x2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            x2 ^= arr2[i];
        }
        return x1 & x2;
    }
}