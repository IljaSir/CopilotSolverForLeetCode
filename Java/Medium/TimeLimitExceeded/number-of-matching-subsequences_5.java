class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int count = 0;
        for(String word : words){
            int i = 0;
            int j = 0;
            while(i < s.length() && j < word.length()){
                if(s.charAt(i) == word.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if(j == word.length()){
                count++;
            }
        }
        return count;
    }
}