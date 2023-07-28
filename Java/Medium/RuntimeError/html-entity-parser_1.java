class Solution {
    public String entityParser(String text) {
        
        HashMap<String, Character> map = new HashMap<String, Character>();
        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                int j = i + 1;
                while (j < text.length() && text.charAt(j) != ';') {
                    j++;
                }
                if (map.containsKey(text.substring(i, j + 1))) {
                    sb.append(map.get(text.substring(i, j + 1)));
                    i = j;
                } else {
                    sb.append(text.charAt(i));
                }
            } else {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }
}