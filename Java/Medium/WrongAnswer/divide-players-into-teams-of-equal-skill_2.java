class Solution {
    public long dividePlayers(int[] skill) {
        
        int n = skill.length;
        Arrays.sort(skill);
        long sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += skill[i] * skill[n - i - 1];
        }
        return sum;
    }
}