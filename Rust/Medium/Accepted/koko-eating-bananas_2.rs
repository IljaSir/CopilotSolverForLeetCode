impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let (mut l, mut r) = (1, 1_000_000_000);
        while l < r {
            let m = (l + r) / 2;
            let mut t = 0;
            for &p in &piles {
                t += (p + m - 1) / m;
            }
            if t > h {
                l = m + 1;
            } else {
                r = m;
            }
        }
        l
    }
}