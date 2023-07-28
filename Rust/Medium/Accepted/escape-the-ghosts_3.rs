impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let dist = |x: i32, y: i32| (target[0] - x).abs() + (target[1] - y).abs();
        let mut me = dist(0, 0);
        for ghost in ghosts {
            if dist(ghost[0], ghost[1]) <= me {
                return false;
            }
        }
        true
    }
}