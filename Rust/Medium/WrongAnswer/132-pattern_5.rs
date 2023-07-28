impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let mut stack = Vec::new();
        let mut third = i32::MIN;
        for i in (0..nums.len()).rev() {
            if nums[i] < third {
                return true;
            }
            while let Some(&top) = stack.last() {
                if nums[i] > top {
                    third = top;
                    break;
                }
                stack.pop();
            }
            stack.push(nums[i]);
        }
        false
    }
}