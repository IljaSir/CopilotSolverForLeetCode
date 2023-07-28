impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let (mut l, mut r) = (1, *piles.iter().max().unwrap());
        while l < r {
            let mid = (l + r) / 2;
            let hours = piles.iter().map(|p| (p - 1) / mid + 1).sum::<i32>();
            if hours > h {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        l
    }
}