impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        let n = bloom_day.len();
        let mut bloom_day = bloom_day;
        bloom_day.sort();
        let mut l = 0;
        let mut r = bloom_day.len() - 1;
        while l < r {
            let mid = l + (r - l) / 2;
            if Self::can_make(&bloom_day, m, k, bloom_day[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if Self::can_make(&bloom_day, m, k, bloom_day[l]) {
            bloom_day[l]
        } else {
            -1
        }
    }
    fn can_make(bloom_day: &[i32], m: i32, k: i32, days: i32) -> bool {
        let mut bouquets = 0;
        let mut flowers = 0;
        for &day in bloom_day {
            if day > days {
                break;
            }
            flowers += 1;
            if flowers == k {
                bouquets += 1;
                flowers = 0;
            }
        }
        bouquets >= m
    }
}