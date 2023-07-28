class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        int[] result = new int[changed.length / 2];
        int i = 0;
        for (int j = 0; j < changed.length; j += 2) {
            if (changed[j] != changed[j + 1]) {
                return new int[0];
            }
            result[i++] = changed[j];
        }
        return result;
    }
}