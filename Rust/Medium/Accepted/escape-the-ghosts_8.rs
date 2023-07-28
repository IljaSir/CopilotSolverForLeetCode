impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let manhattan = |x: i32, y: i32| x.abs() + y.abs();
        let (x, y) = (target[0], target[1]);
        let mut min = manhattan(x, y);
        for ghost in ghosts {
            let (gx, gy) = (ghost[0], ghost[1]);
            let distance = manhattan(x - gx, y - gy);
            if distance <= min {
                return false;
            }
        }
        true
    }
}