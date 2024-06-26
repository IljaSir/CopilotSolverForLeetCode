class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        long p = 1;
        for(int i = 0; i < k; i++){
            p = (p * power) % modulo;
        }
        long hash = 0;
        for(int i = 0; i < k; i++){
            hash = (hash * power + s.charAt(i) - 'a' + 1) % modulo;
        }
        if(hash == hashValue){
            return s.substring(0, k);
        }
        for(int i = k; i < s.length(); i++){
            hash = (hash * power + s.charAt(i) - 'a' + 1 - (s.charAt(i - k) - 'a' + 1) * p % modulo) % modulo;
            if(hash < 0){
                hash += modulo;
            }
            if(hash == hashValue){
                return s.substring(i - k + 1, i + 1);
            }
        }
        return "";
    }
}