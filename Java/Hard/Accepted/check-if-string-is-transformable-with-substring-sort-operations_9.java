class Solution {
    public boolean isTransformable(String s, String t) {
        
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        List<Deque<Integer>> indexList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            indexList.add(new LinkedList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            indexList.get(s.charAt(i) - '0').add(i);
        }
        for (int i = 0; i < t.length(); i++) {
            int digit = t.charAt(i) - '0';
            if (indexList.get(digit).isEmpty()) {
                return false;
            }
            for (int j = 0; j < digit; j++) {
                if (!indexList.get(j).isEmpty() && indexList.get(j).peek() < indexList.get(digit).peek()) {
                    return false;
                }
            }
            indexList.get(digit).poll();
        }
        return true;
    }
}