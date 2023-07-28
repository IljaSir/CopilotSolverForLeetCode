impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let mut l = 1;
        let mut r = 1_000_000_000;
        while l < r {
            let m = (l + r) / 2;
            if Solution::check(nums.as_slice(), max_operations, m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }

    fn check(nums: &[i32], max_operations: i32, m: i32) -> bool {
        let mut ops = 0;
        for &num in nums {
            ops += (num - 1) / m;
        }
        ops <= max_operations
    }
}