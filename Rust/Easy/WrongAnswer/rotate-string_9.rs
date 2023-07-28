impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        
        let s1 = s.clone();
        let s2 = goal.clone();
        let s3 = s1 + &s2;
        s3.contains(&goal)
    }
}