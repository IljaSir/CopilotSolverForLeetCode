impl Solution {
    pub fn ship_within_days(weights: Vec<i32>, days: i32) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        for w in weights.iter() {
            if *w > left {
                left = *w;
            }
            right += *w;
        }
        while left < right {
            let mid = left + (right - left) / 2;
            let mut need = 1;
            let mut cur = 0;
            for w in weights.iter() {
                if cur + w > mid {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if need > days {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}