class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int res = 0;
        List<Integer>[] lists = new List[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            lists[s.charAt(i) - 'a'].add(i);
        }
        for (String word : words) {
            int index = -1;
            boolean isSubsequence = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                List<Integer> list = lists[c - 'a'];
                int j = Collections.binarySearch(list, index + 1);
                if (j < 0) {
                    j = -j - 1;
                }
                if (j >= list.size()) {
                    isSubsequence = false;
                    break;
                }
                index = list.get(j);
            }
            if (isSubsequence) {
                res++;
            }
        }
        return res;
    }
}