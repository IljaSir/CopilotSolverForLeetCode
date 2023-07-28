class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        if (arr.length % 2 != 0) {
            return false;
        }
        int[] neg = new int[200001];
        int[] pos = new int[200001];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                neg[-arr[i]]++;
            } else {
                pos[arr[i]]++;
            }
        }
        for (int i = 0; i < neg.length; i++) {
            if (neg[i] > 0) {
                if (i % 2 == 1) {
                    return false;
                }
                int j = i / 2;
                if (neg[j] < neg[i]) {
                    return false;
                }
                neg[j] -= neg[i];
            }
        }
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] > 0) {
                if (i % 2 == 1) {
                    return false;
                }
                int j = i / 2;
                if (pos[j] < pos[i]) {
                    return false;
                }
                pos[j] -= pos[i];
            }
        }
        return true;
    }
}