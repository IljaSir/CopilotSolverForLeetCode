impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        let (mut l, mut r) = (0, 1_000_000_000);
        while l < r {
            let mid = (l + r) / 2;
            if Solution::can_make(bloom_day.as_slice(), m, k, mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if Solution::can_make(bloom_day.as_slice(), m, k, l) {
            l
        } else {
            -1
        }
    }
    fn can_make(bloom_day: &[i32], m: i32, k: i32, days: i32) -> bool {
        let (mut bouquets, mut flowers) = (0, 0);
        for &bloom in bloom_day {
            if bloom <= days {
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