impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let mut l = 1;
        let mut r = *nums.iter().max().unwrap();
        while l < r {
            let mid = (l + r) / 2;
            let mut ops = 0;
            for &num in nums.iter() {
                ops += (num - 1) / mid;
            }
            if ops <= max_operations {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l
    }
}