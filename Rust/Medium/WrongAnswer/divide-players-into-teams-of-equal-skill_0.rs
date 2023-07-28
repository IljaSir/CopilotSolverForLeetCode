impl Solution {
    pub fn divide_players(skill: Vec<i32>) -> i64 {
        
        let mut skill = skill;
        skill.sort();
        let mut sum = 0;
        for i in (0..skill.len()).step_by(2) {
            sum += skill[i] as i64 * skill[i + 1] as i64;
        }
        sum
    }
}