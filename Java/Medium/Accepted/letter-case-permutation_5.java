class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> res = new ArrayList<String>();
        res.add(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int n = res.size();
                for (int j = 0; j < n; j++) {
                    char[] ch = res.get(j).toCharArray();
                    if (Character.isUpperCase(ch[i])) {
                        ch[i] = Character.toLowerCase(ch[i]);
                    } else {
                        ch[i] = Character.toUpperCase(ch[i]);
                    }
                    res.add(String.valueOf(ch));
                }
            }
        }
        return res;
    }
}