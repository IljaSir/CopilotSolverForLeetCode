impl Solution {
    pub fn sub_array_ranges(nums: Vec<i32>) -> i64 {
        
        let mut result = 0;
        let mut stack = vec![];
        let mut prev = 0;
        for i in 0..nums.len() {
            while let Some(&x) = stack.last() {
                if nums[x] <= nums[i] {
                    break;
                }
                stack.pop();
            }
            let left = if let Some(&x) = stack.last() {
                x + 1
            } else {
                0
            };
            result += (i - left + 1) as i64 * (nums[i] - prev) as i64;
            prev = nums[i];
            stack.push(i);
        }
        result
    }
}