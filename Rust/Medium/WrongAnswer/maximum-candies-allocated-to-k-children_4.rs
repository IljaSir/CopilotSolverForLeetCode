impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut candies = candies;
        candies.sort();
        let mut l = 0;
        let mut r = candies.len() as i64;
        while l < r {
            let m = (l + r + 1) / 2;
            let mut sum = 0;
            for i in 0..candies.len() {
                sum += (candies[i] as i64 / m) as i32;
            }
            if sum as i64 >= k {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l as i32
    }
}