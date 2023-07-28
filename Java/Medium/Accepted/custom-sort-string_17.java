class Solution {
    public String customSortString(String order, String s) {
        
        int[] orderMap = new int[26];
        int orderIndex = 1;
        for (char c : order.toCharArray()) {
            orderMap[c - 'a'] = orderIndex++;
        }
        Character[] cs = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cs[i] = s.charAt(i);
        }
        Arrays.sort(cs, (c1, c2) -> {
            int index1 = orderMap[c1 - 'a'];
            int index2 = orderMap[c2 - 'a'];
            if (index1 == 0 && index2 == 0) {
                return c1 - c2;
            }
            return index1 - index2;
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : cs) {
            sb.append(c);
        }
        return sb.toString();
    }
}