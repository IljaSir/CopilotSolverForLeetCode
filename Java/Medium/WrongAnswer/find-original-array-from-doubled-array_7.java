class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 != 0) {
            return new int[]{};
        }
        int[] result = new int[changed.length / 2];
        Arrays.sort(changed);
        int i = 0;
        int j = 0;
        while (i < changed.length) {
            if (i == changed.length - 1) {
                return new int[]{};
            }
            if (changed[i] != changed[i + 1]) {
                return new int[]{};
            }
            result[j++] = changed[i];
            i += 2;
        }
        return result;
    }
}