impl Solution {
    pub fn maximum_candies(candies: Vec<i32>, k: i64) -> i32 {
        
        let mut lo = 0;
        let mut hi = 10000000000000000;
        while lo < hi {
            let mid = (lo + hi + 1) / 2;
            if Solution::can_allocate(&candies, k, mid) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        lo as i32
    }
    fn can_allocate(candies: &Vec<i32>, k: i64, mid: i64) -> bool {
        let mut count = 0;
        for &candy in candies.iter() {
            count += (candy as i64 / mid) as i64;
        }
        count >= k
    }
}