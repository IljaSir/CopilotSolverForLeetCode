class Solution {
    public int longestBeautifulSubstring(String word) {
        
        int n = word.length();
        int max = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        while(end < n){
            if(end == n - 1){
                if(word.charAt(end) >= word.charAt(end - 1)){
                    count++;
                }
                if(count == 5){
                    max = Math.max(max, end - start + 1);
                }
                break;
            }
            if(word.charAt(end) < word.charAt(end + 1)){
                end++;
                count++;
            }else if(word.charAt(end) > word.charAt(end + 1)){
                if(count == 5){
                    max = Math.max(max, end - start + 1);
                }
                end++;
                start = end;
                count = 0;
            }else{
                end++;
            }
        }
        return max;
    }
}