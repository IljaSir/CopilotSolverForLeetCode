impl Solution {
    pub fn max_run_time(n: i32, batteries: Vec<i32>) -> i64 {
        
        let n = n as usize;
        let mut batteries = batteries;
        batteries.sort();
        let mut l = 0;
        let mut r = batteries[n - 1] as i64;
        let mut res = 0;
        while l <= r {
            let mid = (l + r) / 2;
            let mut ok = true;
            let mut cnt = 0;
            for i in 0..n {
                cnt += (mid / batteries[i] as i64) as usize;
                if cnt >= n {
                    break;
                }
            }
            if cnt >= n {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        res
    }
}