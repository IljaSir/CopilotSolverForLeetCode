impl Solution {
    pub fn longest_obstacle_course_at_each_position(obstacles: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut dp = Vec::new();
        for &obstacle in obstacles.iter() {
            let pos = dp.binary_search(&obstacle).unwrap_or_else(|x| x);
            if pos == dp.len() {
                dp.push(obstacle);
            } else {
                dp[pos] = obstacle;
            }
            res.push(pos as i32 + 1);
        }
        res
    }
}