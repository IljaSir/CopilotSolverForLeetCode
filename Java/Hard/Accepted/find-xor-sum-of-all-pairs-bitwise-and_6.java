class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        
        int res1 = 0;
        for (int num : arr1) {
            res1 ^= num;
        }
        int res2 = 0;
        for (int num : arr2) {
            res2 ^= num;
        }
        return res1 & res2;
    }
}