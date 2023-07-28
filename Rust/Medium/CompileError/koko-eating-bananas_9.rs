impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let mut min = 1;
        let mut max = piles.iter().max().unwrap();
        while min < max {
            let mid = (min + max) / 2;
            let mut hours = 0;
            for pile in &piles {
                hours += (pile - 1) / mid + 1;
                if hours > h {
                    break;
                }
            }
            if hours <= h {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        min
    }
}