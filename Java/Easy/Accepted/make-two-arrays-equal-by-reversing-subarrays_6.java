class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        
        int[] targetCount = new int[1001];
        int[] arrCount = new int[1001];
        
        for (int i = 0; i < target.length; i++) {
            targetCount[target[i]]++;
            arrCount[arr[i]]++;
        }
        
        for (int i = 0; i < 1001; i++) {
            if (targetCount[i] != arrCount[i]) {
                return false;
            }
        }
        
        return true;
    }
}