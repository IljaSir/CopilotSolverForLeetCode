class Solution {
    public String frequencySort(String s) {
        
        int[] freq = new int[128];
        for (char c: s.toCharArray()) {
            freq[c]++;
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c = 0; c < 128; c++) {
            int f = freq[c];
            if (f > 0) {
                if (bucket[f] == null) {
                    bucket[f] = new ArrayList();
                }
                bucket[f].add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (bucket[i] != null) {
                for (char c: bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}