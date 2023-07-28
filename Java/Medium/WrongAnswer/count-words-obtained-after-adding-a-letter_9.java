class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;
        for(String target: targetWords){
            for(String start: startWords){
                if(target.length() == start.length()){
                    int[] targetFreq = new int[26];
                    int[] startFreq = new int[26];
                    for(int i=0; i<target.length(); i++){
                        targetFreq[target.charAt(i) - 'a']++;
                        startFreq[start.charAt(i) - 'a']++;
                    }
                    boolean flag = true;
                    for(int i=0; i<26; i++){
                        if(targetFreq[i] > startFreq[i]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}