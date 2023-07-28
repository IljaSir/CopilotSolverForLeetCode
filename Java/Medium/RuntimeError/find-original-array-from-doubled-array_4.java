class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        int[] cnt = new int[100001];
        for (int x : changed) {
            cnt[x]++;
        }
        int[] res = new int[changed.length / 2];
        int idx = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (cnt[i] > cnt[i * 2]) {
                return new int[0];
            }
            for (int j = 0; j < cnt[i]; j++) {
                res[idx++] = i;
            }
            cnt[i * 2] -= cnt[i];
        }
        return res;
    }
}