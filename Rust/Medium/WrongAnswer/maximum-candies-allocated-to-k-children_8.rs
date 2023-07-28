impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut candies = candies;
        candies.sort();
        let mut lo = 0;
        let mut hi = candies.len();
        let mut mid = (lo + hi) >> 1;
        let mut res = 0;
        while lo < hi {
            mid = (lo + hi) >> 1;
            let mut sum = 0;
            for i in 0..candies.len() {
                sum += candies[i].min(mid as i32) as i64;
            }
            if sum <= k {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        res as i32
    }
}