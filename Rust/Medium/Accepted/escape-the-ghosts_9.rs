impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let target = (target[0] as i64, target[1] as i64);
        let mut min_distance = std::i64::MAX;
        for ghost in ghosts {
            let ghost = (ghost[0] as i64, ghost[1] as i64);
            let distance = (target.0 - ghost.0).abs() + (target.1 - ghost.1).abs();
            if distance < min_distance {
                min_distance = distance;
            }
        }
        let distance = target.0.abs() + target.1.abs();
        distance < min_distance
    }
}