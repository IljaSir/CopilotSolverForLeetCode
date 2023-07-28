impl Solution {
    pub fn divide_players(skill: Vec<i32>) -> i64 {
        
        let mut skill = skill;
        skill.sort();
        let n = skill.len();
        let mut ans = 0;
        for i in 0..n/2 {
            ans += skill[i] as i64 * skill[n-i-1] as i64;
        }
        ans
    }
}