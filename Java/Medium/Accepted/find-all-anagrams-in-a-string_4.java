class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<Integer>();
        int[] count = new int[26];
        for(int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0, total = p.length();
        while(right < s.length()) {
            if(count[s.charAt(right++) - 'a']-- >= 1) {
                total--;
            }
            if(total == 0) {
                res.add(left);
            }
            if(right - left == p.length() && count[s.charAt(left++) - 'a']++ >= 0) {
                total++;
            }
        }
        return res;
    }
}