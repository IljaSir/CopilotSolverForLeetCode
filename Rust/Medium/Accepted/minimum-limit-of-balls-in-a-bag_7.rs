impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let mut l = 1;
        let mut r = 1_000_000_000;
        while l < r {
            let mid = (l + r) >> 1;
            let mut cnt = 0;
            for &x in &nums {
                cnt += (x - 1) / mid;
            }
            if cnt <= max_operations {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l
    }
}