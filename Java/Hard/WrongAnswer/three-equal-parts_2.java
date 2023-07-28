class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int count = 0;
        for (int i : arr) {
            if (i == 1) {
                count++;
            }
        }
        if (count == 0) {
            return new int[]{0, arr.length - 1};
        }
        if (count % 3 != 0) {
            return new int[]{-1, -1};
        }
        int k = count / 3;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int i = 0;
        while (k > 0) {
            if (arr[i] == 1) {
                k--;
            }
            i++;
        }
        p1 = i - 1;
        while (i < arr.length && arr[i] == 0) {
            i++;
        }
        p2 = i;
        while (i < arr.length && arr[i] == 0) {
            i++;
        }
        p3 = i;
        while (p3 < arr.length) {
            if (arr[p1] != arr[p2] || arr[p2] != arr[p3]) {
                return new int[]{-1, -1};
            }
            p1++;
            p2++;
            p3++;
        }
        return new int[]{p1 - 1, p2};
    }
}