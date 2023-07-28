impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let mut lo = 1;
        let mut hi = piles.iter().max().unwrap().clone();
        while lo < hi {
            let mid = (lo + hi) / 2;
            let mut hours = 0;
            for pile in &piles {
                hours += (pile + mid - 1) / mid;
            }
            if hours > h {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        lo
    }
}