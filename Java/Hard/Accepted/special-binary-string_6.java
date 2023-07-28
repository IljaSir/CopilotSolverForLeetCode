class Solution {
    public String makeLargestSpecial(String s) {
        
        int count = 0;
        int start = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            if (count == 0) {
                list.add('1' + makeLargestSpecial(s.substring(start + 1, i)) + '0');
                start = i + 1;
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str: list) sb.append(str);
        return sb.toString();
    }
}