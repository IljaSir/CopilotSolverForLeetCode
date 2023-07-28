class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        
        int[] freq = new int[1001];
        for (int i = 0; i < target.length; i++) {
            freq[target[i]]++;
            freq[arr[i]]--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}