class Solution {
    public long dividePlayers(int[] skill) {
        
        long sum = 0;
        int n = skill.length;
        Arrays.sort(skill);
        for (int i = 0; i < n / 2; i++) {
            sum += skill[i] * skill[n - 1 - i];
        }
        return sum;
    }
}