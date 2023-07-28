class Solution {
    public String entityParser(String text) {
        
        // "&quot;": '"',
        // "&apos;": "'",
        // "&amp;": "&",
        // "&gt;": ">",
        // "&lt;": "<",
        // "&frasl;": "/"
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == '&') {
                int j = i;
                while (j < text.length() && text.charAt(j) != ';') {
                    j++;
                }
                String key = text.substring(i, j + 1);
                if (map.containsKey(key)) {
                    sb.append(map.get(key));
                } else {
                    sb.append(key);
                }
                i = j + 1;
            } else {
                sb.append(text.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}