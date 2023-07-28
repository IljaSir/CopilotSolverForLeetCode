class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        int[] count = new int[200001];
        for (int i : arr) {
            count[i + 100000]++;
        }
        for (int i = 0; i < 100000; i++) {
            if (count[i] > count[200000 - i]) {
                return false;
            }
            count[200000 - i] -= count[i];
        }
        return true;
    }
}