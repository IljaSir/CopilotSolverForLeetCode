class Solution {
    public int minFlips(String target) {
        
        int count = 0;
        char c = '0';
        for(int i=0;i<target.length();i++){
            if(target.charAt(i) != c){
                count++;
                c = target.charAt(i);
            }
        }
        return count;
    }
}