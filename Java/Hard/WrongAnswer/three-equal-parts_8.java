class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int n = arr.length;
        int[] ans = new int[]{-1, -1};
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                totalOnes++;
            }
        }
        if (totalOnes == 0) {
            return new int[]{0, n - 1};
        }
        if (totalOnes % 3 != 0) {
            return ans;
        }
        int onesInEachPart = totalOnes / 3;
        int firstPartEnd = -1;
        int secondPartEnd = -1;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ones++;
            }
            if (ones == onesInEachPart) {
                if (firstPartEnd == -1) {
                    firstPartEnd = i;
                } else {
                    secondPartEnd = i;
                }
                ones = 0;
            }
        }
        int i = firstPartEnd;
        int j = secondPartEnd;
        while (i < n && arr[i] == 0) {
            i++;
        }
        while (j < n && arr[j] == 0) {
            j++;
        }
        while (i < n && j < n) {
            if (arr[i] != arr[j]) {
                return ans;
            }
            i++;
            j++;
        }
        if (i == n || j == n) {
            return new int[]{i - 1, j};
        }
        return ans;
    }
}