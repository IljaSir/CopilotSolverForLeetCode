impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        
        let (mut left, mut right) = (0, 1_000_000_000i64);
        while left < right {
            let mid = (left + right) / 2;
            let mut trips = 0;
            for &t in &time {
                trips += mid / t as i64;
            }
            if trips >= total_trips as i64 {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}