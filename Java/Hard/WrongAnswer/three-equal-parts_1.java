class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int ones = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ones++;
            }
        }
        if (ones == 0) {
            return new int[]{0, arr.length - 1};
        }
        if (ones % 3 != 0) {
            return new int[]{-1, -1};
        }
        int onesInEachPart = ones / 3;
        int[] firstPart = findLastOne(arr, onesInEachPart);
        int[] secondPart = findLastOne(arr, 2 * onesInEachPart);
        int[] thirdPart = findLastOne(arr, 3 * onesInEachPart);
        if (firstPart[0] == -1 || secondPart[0] == -1 || thirdPart[0] == -1) {
            return new int[]{-1, -1};
        }
        while (thirdPart[1] < arr.length && arr[firstPart[1]] == arr[secondPart[1]] && arr[secondPart[1]] == arr[thirdPart[1]]) {
            firstPart[1]++;
            secondPart[1]++;
            thirdPart[1]++;
        }
        if (thirdPart[1] == arr.length) {
            return new int[]{firstPart[1] - 1, secondPart[1]};
        }
        return new int[]{-1, -1};
    }
    
    private int[] findLastOne(int[] arr, int ones) {
        int[] result = new int[]{-1, -1};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == ones) {
                    result[0] = i;
                }
                result[1] = i;
            }
        }
        return result;
    }
}