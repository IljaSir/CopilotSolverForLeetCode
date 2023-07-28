impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        nums.iter().skip(1).fold((0, nums[0]), |(mut ops, mut prev), &cur| {
            if cur <= prev {
                ops += prev - cur + 1;
                prev += 1;
            } else {
                prev = cur;
            }
            (ops, prev)
        }).0
    }
}