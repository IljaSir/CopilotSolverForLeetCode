impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let (mut l, mut r) = (1, *nums.iter().max().unwrap());
        while l < r {
            let m = l + (r - l) / 2;
            if Self::check(&nums, max_operations, m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        l
    }
    fn check(nums: &[i32], max_operations: i32, m: i32) -> bool {
        let mut operations = 0;
        for &x in nums {
            operations += (x - 1) / m;
            if operations > max_operations {
                return false;
            }
        }
        true
    }
}