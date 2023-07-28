class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        String last = folder[0];
        for (int i = 1; i < folder.length; i++) {
            if (folder[i].indexOf(last + "/") != 0) {
                result.add(folder[i]);
                last = folder[i];
            }
        }
        return result;
    }
}