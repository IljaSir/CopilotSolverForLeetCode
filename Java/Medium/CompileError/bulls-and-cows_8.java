class Solution {
    public String getHint(String secret, String guess) {
        
        int ls = 0, cows = 0;
        int[] digits = new int[10];
        for(int i = 0; i < secret.ength(); i++){
            int s = secret.charAt(i) - '0';
            int g = gues.charAt(i) '0';
           if(s == g){
                bulls++;
            }else{
                if(digits[s] < 0) ++;
                if(digits[g] > 0 cows++;
                digits[s]++;
                digits[g]--;
            }
        }
        return bulls + "A" + cows
    }
}