class Solution {
    public String removeStars(String s) {
        
        char[] chars = s.toCharArray();
        List<Integer> starIndexes = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                starIndexes.add(i);
            }
        }
        int starCount = starIndexes.size();
        int[] lefts = new int[starCount];
        int[] rights = new int[starCount];
        lefts[0] = starIndexes.get(0) - 1;
        for (int i = 1; i < starCount; i++) {
            lefts[i] = starIndexes.get(i) - starIndexes.get(i - 1) - 2;
        }
        rights[starCount - 1] = chars.length - starIndexes.get(starCount - 1) - 1;
        for (int i = starCount - 2; i >= 0; i--) {
            rights[i] = starIndexes.get(i + 1) - starIndexes.get(i) - 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < starCount; i++) {
            int left = lefts[i];
            int right = rights[i];
            if (left >= right) {
                sb.append(chars[starIndexes.get(i) - left - 1]);
            }
            else {
                sb.append(chars[starIndexes.get(i) + right + 1]);
            }
        }
        return sb.toString();
    }
}