class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String prev = "";
        for (String s : folder) {
            if (!s.startsWith(prev + "/")) {
                result.add(s);
                prev = s;
            }
        }
        return result;
    }
}