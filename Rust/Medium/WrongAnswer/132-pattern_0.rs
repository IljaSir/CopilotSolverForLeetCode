impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let mut stack = vec![];
        let mut k = std::i32::MIN;
        for i in (0..nums.len()).rev() {
            if nums[i] < k {
                return true;
            }
            while let Some(&top) = stack.last() {
                if nums[i] > top {
                    k = top;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        false
    }
}