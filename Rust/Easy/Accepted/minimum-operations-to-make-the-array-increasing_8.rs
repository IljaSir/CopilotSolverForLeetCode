impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut ops = 0;
        let mut last = nums[0];
        for n in nums.iter().skip(1) {
            if *n <= last {
                ops += last - n + 1;
                last += 1;
            } else {
                last = *n;
            }
        }
        ops
    }
}