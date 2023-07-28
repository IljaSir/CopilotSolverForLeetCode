impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        
        let mut lo = 0;
        let mut hi = 1_000_000_000;
        while lo < hi {
            let mid = (lo + hi) / 2;
            if Self::check(&time, mid, total_trips) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo as i64
    }
    
    fn check(time: &[i32], t: i32, total_trips: i32) -> bool {
        let mut trips = 0;
        for &t1 in time {
            trips += t / t1;
            if trips >= total_trips {
                return true;
            }
        }
        false
    }
}