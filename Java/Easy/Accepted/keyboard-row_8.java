class Solution {
    public String[] findWords(String[] words) {
        
        List<String> list = new ArrayList<>();
        for (String s: words) {
            if (check(s)) {
                list.add(s);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public boolean check(String s) {
        s = s.toLowerCase();
        String[] row = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int index = -1;
        for (int i = 0; i < 3; i++) {
            if (row[i].indexOf(s.charAt(0)) != -1) {
                index = i;
                break;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            if (row[index].indexOf(s.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}