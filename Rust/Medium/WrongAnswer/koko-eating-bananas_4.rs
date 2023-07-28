impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        if piles.len() == 1 {
            return (piles[0] as f64 / h as f64).ceil() as i32;
        }
        let mut l = 1;
        let mut r = piles.iter().max().unwrap().clone();
        while l <= r {
            let mid = l + (r - l) / 2;
            if Self::can_finish(piles.clone(), h, mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l
    }
    fn can_finish(piles: Vec<i32>, h: i32, k: i32) -> bool {
        let mut hours = 0;
        for pile in piles {
            hours += (pile as f64 / k as f64).ceil() as i32;
        }
        hours <= h
    }
}