impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let distance = (target[0].abs() + target[1].abs()) as i32;
        for ghost in ghosts {
            if (ghost[0] - target[0]).abs() + (ghost[1] - target[1]).abs() <= distance {
                return false;
            }
        }
        true
    }
}