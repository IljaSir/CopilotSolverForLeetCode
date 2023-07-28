class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        int[] count = new int[101];
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += count[target - arr[i]];
            for (int j = 0; j < i; j++) {
                count[arr[i] + arr[j]]++;
            }
        }
        return (int)(res % 1000000007);
    }
}