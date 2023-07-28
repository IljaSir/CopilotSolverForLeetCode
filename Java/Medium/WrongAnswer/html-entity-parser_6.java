class Solution {
    public String entityParser(String text) {
        
        String[] entities = new String[]{"&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;"};
        String[] symbols = new String[]{"\"", "'", "&", ">", "<", "/"};
        
        for (int i = 0; i < entities.length; i++) {
            text = text.replaceAll(entities[i], symbols[i]);
        }
        
        return text;
    }
}