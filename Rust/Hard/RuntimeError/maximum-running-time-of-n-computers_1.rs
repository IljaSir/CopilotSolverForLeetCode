impl Solution {
    pub fn max_run_time(n: i32, batteries: Vec<i32>) -> i64 {
        
        let n = n as usize;
        let mut batteries = batteries;
        batteries.sort();
        let mut lo = 0;
        let mut hi = batteries.len() - 1;
        let mut ans = 0;
        while lo <= hi {
            let mid = lo + (hi - lo) / 2;
            let mut cur = 0;
            let mut ok = true;
            for i in 0..n {
                if cur >= batteries[mid] {
                    ok = false;
                    break;
                }
                cur += batteries[mid + i];
            }
            if ok {
                lo = mid + 1;
                ans = batteries[mid];
            } else {
                hi = mid - 1;
            }
        }
        ans as i64 * n as i64
    }
}