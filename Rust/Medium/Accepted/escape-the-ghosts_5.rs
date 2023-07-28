impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut dist = 0;
        for i in 0..2 {
            dist += target[i].abs();
        }
        for ghost in ghosts {
            let mut gdist = 0;
            for i in 0..2 {
                gdist += (ghost[i] - target[i]).abs();
            }
            if gdist <= dist {
                return false;
            }
        }
        true
    }
}