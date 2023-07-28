impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        
        let mut l = 0;
        let mut r = 1_000_000_000i64;
        while l < r {
            let m = l + (r - l) / 2;
            let mut cnt = 0;
            for &t in &time {
                cnt += m / t as i64;
                if cnt >= total_trips as i64 {
                    break;
                }
            }
            if cnt >= total_trips as i64 {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
}