impl Solution {
    pub fn max_run_time(n: i32, batteries: Vec<i32>) -> i64 {
        
        let mut batteries = batteries;
        batteries.sort();
        let mut l = 0;
        let mut r = batteries.len() as i64;
        while l < r {
            let m = l + (r - l) / 2;
            if Solution::check(&batteries, m as usize, n as usize) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l
    }
    fn check(batteries: &Vec<i32>, m: usize, n: usize) -> bool {
        let mut t = 0;
        let mut i = 0;
        while i < n {
            let j = i + m;
            if j >= batteries.len() {
                return false;
            }
            t += batteries[j] as i64;
            i += 1;
            if t < i as i64 {
                return false;
            }
        }
        true
    }
}