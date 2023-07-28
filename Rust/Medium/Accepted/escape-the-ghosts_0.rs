impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let d = target[0].abs() + target[1].abs();
        for g in ghosts {
            if (g[0] - target[0]).abs() + (g[1] - target[1]).abs() <= d {
                return false;
            }
        }
        true
    }
}