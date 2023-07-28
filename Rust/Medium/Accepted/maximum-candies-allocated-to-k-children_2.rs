impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut l = 0;
        let mut r = *candies.iter().max().unwrap() as i64;
        while l < r {
            let m = l + (r - l + 1) / 2;
            let mut n = 0;
            for x in candies.iter() {
                n += *x as i64 / m;
            }
            if n >= k {
                l = m;
            } else {
                r = m - 1;
            }
        }
        l as i32
    }
}