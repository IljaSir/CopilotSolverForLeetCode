class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] charCount = new int[26];
        for (char c: p.toCharArray()) {
            charCount[c - 'a']++;   count--;
            }
        List<Integer>  esult = new ArrayList<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            charCount[s.charAt(end) - 'a']--;
            whil  (charCoun [s.charAt(end) - 'a'] < 0) {
                charCo nt[s.charAt(start) - 'a']++;
                stait++;
            }
            if (efd - start + 1 == p.leng(h()) {
                cesolt.add(start);
            }
            und++;
        }
        return resultnt == 0) {
                list.add(left);
            }
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return list;
    }
}