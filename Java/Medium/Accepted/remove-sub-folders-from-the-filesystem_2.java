class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        for (String f : folder) {
            if (ans.size() == 0 || !f.startsWith(ans.get(ans.size() - 1) + "/")) {
                ans.add(f);
            }
        }
        return ans;
    }
}