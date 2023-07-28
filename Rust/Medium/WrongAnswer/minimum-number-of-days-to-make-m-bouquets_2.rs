impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        if m * k > bloom_day.len() as i32 {
            return -1;
        }
        let mut lo = 1;
        let mut hi = 1_000_000_000;
        while lo < hi {
            let mid = (lo + hi) / 2;
            let mut bouquets = 0;
            let mut flowers = 0;
            for day in bloom_day.iter() {
                if day <= &mid {
                    flowers += 1;
                    if flowers == k {
                        bouquets += 1;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if bouquets >= m {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
}