class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count == 0) {
            return new int[]{0, arr.length - 1};
        }
        if (count % 3 != 0) {
            return new int[]{-1, -1};
        }
        int one = count / 3;
        int[] result = new int[2];
        int index = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count1++;
            }
            if (count1 == 1 && arr[i] == 0) {
                result[0] = i;
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count2++;
            }
            if (count2 == one + 1 && arr[i] == 0) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count3++;
            }
            if (count3 == one * 2 + 1 && arr[i] == 0) {
                result[1] = i;
                break;
            }
        }
        if (result[0] == 0 || result[1] == 0) {
            return new int[]{-1, -1};
        }
        if (result[1] >= arr.length || result[1] <= result[0]) {
            return new int[]{-1, -1};
        }
        for (int i = result[0]; i < result[1]; i++) {
            if (arr[i] != arr[i + index]) {
                return new int[]{-1, -1};
            }
        }
        return result;
    }
}