class Solution {
    public int divisorSubstrings(int num, int k) {
        
        String s = Integer.toString(num);
        int count = 0;
        for(int i=0;i<=s.length()-k;i++) {
            String t = s.substring(i, i+k);
            int n = Integer.parseInt(t);
            if(num % n == 0) {
                count++;
            }
        }
        return count;
    }
}