impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        
        let n = time.len();
        let mut trips = vec![0; n];
        let mut l = 0;
        let mut r = 1_000_000_000;
        while l + 1 < r {
            let m = (l + r) / 2;
            let mut sum = 0;
            for i in 0..n {
                sum += (m / time[i] as i64) as i32;
            }
            if sum >= total_trips {
                r = m;
            } else {
                l = m;
            }
        }
        r as i64
    }
}