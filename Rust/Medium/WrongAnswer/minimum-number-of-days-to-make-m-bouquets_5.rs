impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        let n = bloom_day.len();
        if m * k > n as i32 {
            return -1;
        }
        let (mut lo, mut hi) = (bloom_day.iter().min().unwrap().clone(), bloom_day.iter().max().unwrap().clone());
        while lo < hi {
            let mid = (lo + hi) / 2;
            if Self::can_make(&bloom_day, m, k, mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
    fn can_make(bloom_day: &Vec<i32>, m: i32, k: i32, day: i32) -> bool {
        let mut bouquets = 0;
        let mut flowers = 0;
        for x in bloom_day {
            if *x <= day {
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