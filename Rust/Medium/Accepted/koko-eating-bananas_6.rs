impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let mut lo = 1;
        let mut hi = 1000000000;
        while lo < hi {
            let mid = (lo + hi) / 2;
            let mut hours = 0;
            for pile in &piles {
                hours += (pile + mid - 1) / mid;
            }
            if hours <= h {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        lo
    }
}