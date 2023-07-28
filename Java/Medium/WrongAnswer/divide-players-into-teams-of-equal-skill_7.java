class Solution {
    public long dividePlayers(int[] skill) {
        
        Arrays.sort(skill);
        long sum = 0;
        for(int i = 0; i < skill.length; i += 2) {
            sum += (long)skill[i] * skill[i + 1];
        }
        return sum;
    }
}