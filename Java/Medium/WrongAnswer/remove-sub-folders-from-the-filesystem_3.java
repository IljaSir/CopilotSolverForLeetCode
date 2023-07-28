class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (i < folder.length - 1 && folder[i + 1].startsWith(folder[i] + "/")) {
                continue;
            }
            result.add(folder[i]);
        }
        return result;
    }
}