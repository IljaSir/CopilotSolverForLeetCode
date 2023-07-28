class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        int[] result = new int[changed.length / 2];
        Arrays.sort(changed);
        int index = 0;
        for (int i = 0; i < changed.length; i += 2) {
            if (changed[i] != changed[i + 1]) {
                return new int[0];
            }
            if (changed[i] % 2 == 1) {
                return new int[0];
            }
            result[index++] = changed[i] / 2;
        }
        return result;
    }
}