impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut prev = nums[0];
        for &num in nums.iter().skip(1) {
            if num <= prev {
                res += prev - num + 1;
                prev += 1;
            } else {
                prev = num;
            }
        }
        res
    }
}