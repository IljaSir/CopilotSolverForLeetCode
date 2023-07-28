class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        int[] count = new int[200001];
        for (int x : arr) {
            count[x + 100000]++;
        }
        for (int x = 0; x <= 100000; x++) {
            if (count[x + 100000] > count[2 * x + 100000]) {
                return false;
            }
            count[2 * x + 100000] -= count[x + 100000];
        }
        return true;
    }
}