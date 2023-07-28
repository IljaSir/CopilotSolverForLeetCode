class Solution {
    public long dividePlayers(int[] skill) {
        
        int n = skill.length;
        Arrays.sort(skill);
        long sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += (long) skill[i] * skill[i + 1];
        }
        return sum;
    }
}