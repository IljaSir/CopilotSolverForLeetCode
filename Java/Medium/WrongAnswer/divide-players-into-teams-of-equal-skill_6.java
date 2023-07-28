class Solution {
    public long dividePlayers(int[] skill) {
        
        Arrays.sort(skill);
        int n = skill.length;
        long sum = 0;
        for(int i = 0; i < n / 2; i++) {
            sum += (long)skill[i] * skill[n - i - 1];
        }
        return sum;
    }
}