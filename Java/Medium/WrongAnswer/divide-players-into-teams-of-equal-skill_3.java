class Solution {
    public long dividePlayers(int[] skill) {
        
        int n = skill.length;
        long sum = 0;
        Arrays.sort(skill);
        for (int i = 0; i < n / 2; i++) {
            sum += (long) skill[i] * skill[n - 1 - i];
        }
        return sum;
    }
}