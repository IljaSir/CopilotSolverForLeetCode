class Solution {
    public String makeLargestSpecial(String s) {
        
        int count = 0;
        int start = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                subs.add('1' + makeLargestSpecial(s.substring(start + 1, i)) + '0');
                start = i + 1;
            }
        }
        Collections.sort(subs, Collections.reverseOrder());
        return String.join("", subs);
    }
}