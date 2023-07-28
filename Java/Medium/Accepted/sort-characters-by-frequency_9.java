class Solution {
    public String frequencySort(String s) {
        
        int[] cnt = new int[128];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        ArrayList<Integer>[] bucket = new ArrayList[s.length() + 1];
        for (int i = 0; i < 128; i++) {
            if (cnt[i] > 0) {
                if (bucket[cnt[i]] == null) {
                    bucket[cnt[i]] = new ArrayList<>();
                }
                bucket[cnt[i]].add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    for (int k = 0; k < i; k++) {
                        sb.append((char)j);
                    }
                }
            }
        }
        return sb.toString();
    }
}