class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        sum += mean * (n + rolls.length);
        if (sum % (n + rolls.length) != 0) {
            return new int[0];
        }
        int avg = sum / (n + rolls.length);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = avg;
        }
        int diff = avg * n;
        for (int i = 0; i < rolls.length; i++) {
            diff -= rolls[i];
        }
        for (int i = 0; i < n; i++) {
            if (diff >= 5) {
                result[i] += 5;
                diff -= 5;
            } else {
                result[i] += diff;
                break;
            }
        }
        return result;
    }
}