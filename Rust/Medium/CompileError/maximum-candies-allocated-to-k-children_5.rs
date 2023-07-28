impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut candies = candies;
        candies.sort();
        let mut lo = 0;
        let mut hi = candies.len() as i64 - 1;
        while lo <= hi {
            let mid = (lo + hi) / 2;
            let mut sum = 0;
            for i in 0..candies.len() {
                sum += candies[i].min(mid) as i64;
            }
            if sum > k {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        hi as i32
    }
}