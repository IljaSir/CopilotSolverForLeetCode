impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let (x, y) = (target[0], target[1]);
        let d = x.abs() + y.abs();
        for g in ghosts {
            let (gx, gy) = (g[0], g[1]);
            if gx.abs() + gy.abs() <= d {
                return false;
            }
        }
        true
    }
}