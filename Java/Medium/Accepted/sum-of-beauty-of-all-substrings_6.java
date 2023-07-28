class Solution {
    public int beautySum(String s) {
        
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a']++;
                sum += getBeauty(freq);
            }
        }
        return sum;
    }
    public int getBeauty(int[] freq){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0){
                max = Math.max(max, freq[i]);
                min = Math.min(min, freq[i]);
            }
        }
        return max - min;
    }
}