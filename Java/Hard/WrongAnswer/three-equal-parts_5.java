class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int[] res = new int[]{-1, -1};
        int ones = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) ones++;
        }
        if (ones == 0) return new int[]{0, arr.length - 1};
        if (ones % 3 != 0) return res;
        int part = ones / 3;
        int start = -1, end = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == 1) start = i;
                if (count == part + 1) {
                    end = i;
                    break;
                }
            }
        }
        int[] startEnd = findEnd(arr, start, end);
        if (startEnd[0] == -1) return res;
        int[] endEnd = findEnd(arr, startEnd[1] + 1, end);
        if (endEnd[0] == -1) return res;
        return new int[]{startEnd[0], endEnd[1] + 1};
    }
    
    private int[] findEnd(int[] arr, int start, int end) {
        int[] res = new int[]{-1, -1};
        int i = start, j = end;
        while (i < arr.length && j < arr.length) {
            if (arr[i] == arr[j]) {
                i++;
                j++;
            } else {
                return res;
            }
        }
        return new int[]{start, j - 1};
    }
}