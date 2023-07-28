class Solution {
    public int countLargestGroup(int n) {
        
        int[] count = new int[37];
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(char c : Integer.toString(i).toCharArray()) {
                sum += c - '0';
            }
            count[sum]++;
        }
        int max = 0;
        int res = 0;
        for(int i = 0; i < 37; i++) {
            if(count[i] > max) {
                max = count[i];
                res = 1;
            } else if(count[i] == max) {
                res++;
            }
        }
        return res;
    }
}