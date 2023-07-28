class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        int[] arr = new int[10000];
        for (int i : deck) {
            arr[i]++;
        }
        int min = 0;
        for (int i : arr) {
            if (i != 0) {
                min = gcd(min, i);
            }
        }
        return min > 1;
    }
}