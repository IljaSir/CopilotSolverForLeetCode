class Solution {
    public String entityParser(String text) {
        
        String[] entities = {"&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;"};
        String[] chars = {"\"", "'", "&", ">", "<", "/"};
        for (int i = 0; i < entities.length; i++) {
            text = text.replace(entities[i], chars[i]);
        }
        return text;
    }
}