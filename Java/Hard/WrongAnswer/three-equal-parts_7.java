class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int n = arr.length;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count == 0) {
            result[0] = 0;
            result[1] = n - 1;
            return result;
        }
        if (count % 3 != 0) {
            return result;
        }
        int k = count / 3;
        int i = 0;
        while (arr[i] == 0) {
            i++;
        }
        int j = i;
        while (k > 0) {
            if (arr[j] == 1) {
                k--;
            }
            j++;
        }
        int p1 = i;
        int p2 = j;
        while (arr[p1] == 0) {
            p1++;
        }
        while (p2 < n && arr[p1] == arr[p2]) {
            p1++;
            p2++;
        }
        if (p2 == n) {
            result[0] = i - 1;
            result[1] = j;
            return result;
        }
        return result;
    }
}