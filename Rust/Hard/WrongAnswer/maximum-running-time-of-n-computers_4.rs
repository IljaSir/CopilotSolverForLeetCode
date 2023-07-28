impl Solution {
    pub fn max_run_time(n: i32, batteries: Vec<i32>) -> i64 {
        
        let n = n as usize;
        let mut batteries = batteries;
        batteries.sort();
        let mut res = 0;
        for i in 0..n {
            res = res.max(batteries[i] * (n - i) as i32);
        }
        res as i64
    }
}