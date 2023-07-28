class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int[] res = new int[]{-1, -1};
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count == 0) {
            return new int[]{0, len - 1};
        }
        if (count % 3 != 0) {
            return res;
        }
        int part = count / 3;
        int i = 0;
        int j = 0;
        int k = 0;
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        for (int l = 0; l < len; l++) {
            if (arr[l] == 1) {
                if (i == 0) {
                    index1 = l;
                    i++;
                } else if (i == part) {
                    index2 = l;
                    i++;
                } else if (i == 2 * part) {
                    index3 = l;
                    i++;
                } else {
                    i++;
                }
            }
        }
        while (index3 < len && arr[index1] == arr[index2] && arr[index2] == arr[index3]) {
            index1++;
            index2++;
            index3++;
        }
        if (index3 == len) {
            return new int[]{index1 - 1, index2};
        }
        return res;
    }
}