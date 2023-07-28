impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let mut left = 1;
        let mut right = piles.iter().max().unwrap();
        while left < right {
            let mid = left + (right - left) / 2;
            let mut hours = 0;
            for pile in piles.iter() {
                hours += pile / mid;
                if pile % mid != 0 {
                    hours += 1;
                }
            }
            if hours <= h {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}