impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        
        let mut l = 0;
        let mut r = 1_000_000_000_000_000_000;
        while l < r {
            let m = (l + r) / 2;
            let mut trips = 0;
            for t in time.iter() {
                trips += m / *t as i64;
            }
            if trips >= total_trips as i64 {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l as i64
    }
}