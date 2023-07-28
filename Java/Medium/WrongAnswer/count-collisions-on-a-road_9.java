class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();
        int[] next = new int[n];
        Arrays.fill(next, -1);
        int count = 0;
        int i = 0;
        while (i < n) {
            if (directions.charAt(i) == 'S') {
                i++;
            } else {
                int j = i + 1;
                while (j < n && directions.charAt(j) == 'S') {
                    j++;
                }
                if (j == n) {
                    break;
                }
                if (directions.charAt(i) == directions.charAt(j)) {
                    i = j;
                } else {
                    count += 2;
                    i = j + 1;
                }
            }
        }
        return count;
    }
}