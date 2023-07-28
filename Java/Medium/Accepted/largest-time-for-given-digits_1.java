class Solution {
    public String largestTimeFromDigits(int[] arr) {
        
        int max = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                for (int k = 0; k < 4; k++) {
                    if (i == k || j == k) continue;
                    int l = 6 - i - j - k;
                    int hours = 10 * arr[i] + arr[j];
                    int minutes = 10 * arr[k] + arr[l];
                    if (hours < 24 && minutes < 60) {
                        max = Math.max(max, hours * 60 + minutes);
                    }
                }
            }
        }
        return max >= 0 ? String.format("%02d:%02d", max / 60, max % 60) : "";
    }
}