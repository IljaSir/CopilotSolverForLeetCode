class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 == 1) return new int[0];
        int[] res = new int[changed.length / 2];
        Arrays.sort(changed);
        int i = 0, j = 0;
        while (i < changed.length && j < res.length) {
            if (i + 1 < changed.length && changed[i] * 2 == changed[i + 1]) {
                res[j++] = changed[i];
                i += 2;
            } else {
                return new int[0];
            }
        }
        return j == res.length ? res : new int[0];
    }
}