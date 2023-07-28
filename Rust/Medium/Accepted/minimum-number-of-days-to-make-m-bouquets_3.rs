impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        let n = bloom_day.len();
        if n < m as usize * k as usize {
            return -1;
        }
        let mut lo = 1;
        let mut hi = 1_000_000_000;
        while lo < hi {
            let mid = lo + (hi - lo) / 2;
            if Solution::can_make_bouquets(&bloom_day, mid, m, k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
    fn can_make_bouquets(bloom_day: &Vec<i32>, mid: i32, m: i32, k: i32) -> bool {
        let mut bouquets = 0;
        let mut flowers = 0;
        for i in 0..bloom_day.len() {
            if bloom_day[i] <= mid {
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