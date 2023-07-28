class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        
        int n = energy.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{experience[i], energy[i]});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cur = list.get(i);
            int exp = cur[0];
            int ene = cur[1];
            int need = exp + 1 - initialExperience;
            if (need > 0) {
                ans += need;
                initialExperience += need;
            }
            need = ene + 1 - initialEnergy;
            if (need > 0) {
                ans += need;
                initialEnergy += need;
            }
            initialExperience += exp;
            initialEnergy -= ene;
        }
        return ans;
    }
}