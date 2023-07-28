class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        String last = "";
        for (String f : folder) {
            if (!f.startsWith(last + "/")) {
                ans.add(f);
                last = f;
            }
        }
        return ans;
    }
}