impl Solution {
    pub fn minimum_time(time: Vec<i32>, total_trips: i32) -> i64 {
        
        let mut l = 0;
        let mut r = 1_000_000_000_i64;
        let mut ans = r;
        while l <= r {
            let mid = (l + r) / 2;
            let mut sum = 0;
            for &v in &time {
                sum += mid / v as i64;
            }
            if sum >= total_trips as i64 {
                ans = ans.min(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        ans
    }
}