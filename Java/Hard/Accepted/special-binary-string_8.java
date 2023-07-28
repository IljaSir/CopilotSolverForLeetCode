class Solution {
    public String makeLargestSpecial(String s) {
        
        int count = 0, start = 0;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                list.add('1' + makeLargestSpecial(s.substring(start + 1, i)) + '0');
                start = i + 1;
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }
}