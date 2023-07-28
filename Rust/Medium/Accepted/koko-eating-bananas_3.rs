impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let mut left = 1;
        let mut right = piles.iter().max().unwrap().clone();
        while left < right {
            let mid = left + (right - left) / 2;
            let mut hours = 0;
            for pile in &piles {
                hours += pile / mid;
                if pile % mid != 0 {
                    hours += 1;
                }
            }
            if hours > h {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left
    }
}