impl Solution {
    pub fn divide_players(skill: Vec<i32>) -> i64 {
        
        let mut skill = skill;
        skill.sort();
        let mut sum = 0;
        for i in 0..skill.len()/2 {
            sum += skill[i] as i64 * skill[skill.len()-1-i] as i64;
        }
        sum
    }
}