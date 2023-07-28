impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        
        let mut total_trips = total_trips as i64;
        let mut time = time;
        time.sort();
        let mut left = 0;
        let mut right = *time.last().unwrap() as i64 * total_trips;
        while left < right {
            let mid = left + (right - left) / 2;
            let mut count = 0;
            for t in time.iter() {
                count += mid / *t as i64;
                if count >= total_trips {
                    break;
                }
            }
            if count >= total_trips {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}