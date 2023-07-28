class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        List<String> result = new ArrayList<>();
        Arrays.sort(folder);
        String prev = null;
        for (String f : folder) {
            if (prev == null || !f.startsWith(prev + "/")) {
                result.add(f);
                prev = f;
            }
        }
        return result;
    }
}