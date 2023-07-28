impl Solution {
    pub fn ship_within_days(weights: Vec<i32>, days: i32) -> i32 {
        
        let (mut left, mut right) = (1, 500 * weights.len() as i32);
        while left < right {
            let mid = (left + right) / 2;
            let mut cur = 0;
            let mut need = 1;
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