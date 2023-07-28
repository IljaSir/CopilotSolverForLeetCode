class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        List<String> list = new ArrayList<>();
        Arrays.sort(folder);
        String currentPath = folder[0];
        list.add(currentPath);
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(currentPath + "/")) {
                currentPath = folder[i];
                list.add(currentPath);
            }
        }
        return list;
    }
}