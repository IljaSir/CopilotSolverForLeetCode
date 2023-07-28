impl Solution {
    pub fn min_days(bloom_day: Vec<i32>, m: i32, k: i32) -> i32 {
        
        let (mut l, mut r) = (0, 10i32.pow(9) + 1);
        while l < r {
            let mid = (l + r) / 2;
            let mut bouquets = 0;
            let mut flowers = 0;
            for &bloom in bloom_day.iter() {
                if bloom <= mid {
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
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if l == 10i32.pow(9) + 1 {
            -1
        } else {
            l
        }
    }
}