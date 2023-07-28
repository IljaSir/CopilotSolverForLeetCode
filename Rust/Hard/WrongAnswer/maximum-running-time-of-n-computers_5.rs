impl Solution {
    pub fn max_run_time(n: i32, batteries: Vec<i32>) -> i64 {
        
        let n = n as usize;
        let mut batteries = batteries;
        batteries.sort();
        let mut sum = 0;
        let mut ans = 0;
        for i in 0..n {
            ans = ans.max(sum + batteries[i] as i64);
            sum += batteries[i] as i64;
        }
        ans
    }
}