class Solution {
    public String entityParser(String text) {
        
        String[] entities = new String[]{"&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;"};
        String[] chars = new String[]{"\"", "'", "&", ">", "<", "/"};
        for (int i = 0; i < entities.length; i++) {
            text = text.replace(entities[i], chars[i]);
        }
        return text;
    }
}