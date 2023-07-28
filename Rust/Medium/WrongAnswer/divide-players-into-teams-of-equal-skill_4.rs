impl Solution {
    pub fn divide_players(skill: Vec<i32>) -> i64 {
        
        let mut skill = skill;
        skill.sort();
        let mut sum = 0;
        let mut i = 0;
        let mut j = skill.len() - 1;
        while i < j {
            sum += skill[i] as i64 * skill[j] as i64;
            i += 1;
            j -= 1;
        }
        sum
    }
}