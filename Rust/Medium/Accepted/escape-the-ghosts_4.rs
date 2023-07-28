impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let mut dist = 0;
        for i in 0..target.len() {
            dist += target[i].abs();
        }
        for ghost in ghosts {
            let mut d = 0;
            for i in 0..target.len() {
                d += (target[i] - ghost[i]).abs();
            }
            if d <= dist {
                return false;
            }
        }
        return true;
    }
}