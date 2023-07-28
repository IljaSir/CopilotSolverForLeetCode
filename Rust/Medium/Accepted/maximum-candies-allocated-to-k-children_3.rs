impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut left = 0;
        let mut right = *candies.iter().max().unwrap() as i64;
        while left < right {
            let mid = (left + right + 1) >> 1;
            let mut count = 0;
            for &c in candies.iter() {
                count += c as i64 / mid;
            }
            if count >= k {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        left as i32
    }
}