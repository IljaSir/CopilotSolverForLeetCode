impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        let n = bloom_day.len();
        if m * k > n as i32 {
            return -1;
        }
        let mut lo = 0;
        let mut hi = 1_000_000_000;
        while lo < hi {
            let mid = (lo + hi) / 2;
            if Solution::can_make(bloom_day.clone(), m, k, mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
    fn can_make(bloom_day: Vec<i32>, m: i32, k: i32, day: i32) -> bool {
        let mut bouquets = 0;
        let mut flowers = 0;
        for bloom in bloom_day {
            if bloom <= day {
                flowers += 1;
                if flowers == k {
                    bouquets += 1;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        bouquets >= m
    }
}