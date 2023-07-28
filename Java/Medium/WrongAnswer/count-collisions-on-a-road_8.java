class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int num = 0;
        for(int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if(c == 'L') {
                num += right[i];
            } else if(c == 'R') {
                num += left[i];
            }
            if(i > 0) {
                left[i] = left[i - 1];
                right[i] = right[i - 1];
            }
            if(c == 'L') {
                left[i]++;
            } else if(c == 'R') {
                right[i]++;
            }
        }
        return num;
    }
}