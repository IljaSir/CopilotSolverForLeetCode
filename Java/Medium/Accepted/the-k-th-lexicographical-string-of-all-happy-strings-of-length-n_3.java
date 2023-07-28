class Solution {
    public String getHappyString(int n, int k) {
        
        List<String> list = new ArrayList<>();
        char[] chars = new char[]{'a', 'b', 'c'};
        for (int i = 0; i < chars.length; i++) {
            list.add(String.valueOf(chars[i]));
        }
        for (int i = 1; i < n; i++) {
            List<String> nextList = new ArrayList<>();
            for (String s : list) {
                for (int j = 0; j < chars.length; j++) {
                    if (s.charAt(s.length() - 1) != chars[j]) {
                        nextList.add(s + chars[j]);
                    }
                }
            }
            list = nextList;
        }
        if (list.size() < k) {
            return "";
        }
        Collections.sort(list);
        return list.get(k - 1);
    }
}