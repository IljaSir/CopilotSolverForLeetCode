class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        
        List<Integer> res = new ArrayList<>();
        int n = favoriteCompanies.size();
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String s : favoriteCompanies.get(i)) {
                mask[i] |= 1 << (s.hashCode() & 31);
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (i == j) continue;
                if ((mask[i] & mask[j]) == mask[i]) break;
            }
            if (j == n) res.add(i);
        }
        return res;
    }
}