class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int left = 0;
        int right = 0;
        int result = 0;
        int count = 0;
        while (left < prizePositions.length) {
            while (right < prizePositions.length && prizePositions[right] - prizePositions[left] <= k) {
                if (prizePositions[left] == prizePositions[right]) {
                    count++;
                }
                right++;
            }
            result = Math.max(result, right - left + count);
            if (prizePositions[left] == prizePositions[left + 1]) {
                count--;
            }
            left++;
        }
        return result;
    }
}