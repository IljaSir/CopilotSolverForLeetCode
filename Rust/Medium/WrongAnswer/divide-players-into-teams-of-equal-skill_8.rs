impl Solution {
    pub fn divide_players(skill: Vec<i32>) -> i64 {
        
        let mut skill = skill;
        skill.sort();
        let mut sum = 0;
        let mut i = 0;
        while i < skill.len() {
            sum += (skill[i] * skill[i + 1]) as i64;
            i += 2;
        }
        sum
    }
}