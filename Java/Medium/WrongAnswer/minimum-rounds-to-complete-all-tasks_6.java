class Solution {
    public int minimumRounds(int[] tasks) {
        
        int n = tasks.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(tasks);
        int i = 0;
        int j = n-1;
        int rounds = 0;
        while (i <= j) {
            int max = tasks[j];
            int min = tasks[i];
            int diff = max - min;
            if (diff == 0) {
                rounds += 1;
                i++;
                j--;
            } else {
                int num = j-i+1;
                int minRounds = (num+2)/3;
                int maxRounds = num/2;
                int r = 0;
                if (diff <= 1) {
                    r = minRounds;
                } else {
                    r = maxRounds;
                }
                rounds += r;
                i += r*2;
                j -= r;
            }
        }
        return rounds;
    }
}