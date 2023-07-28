impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        if n < 3 {
            return false;
        }
        let mut stack = vec![];
        let mut k = std::i32::MIN;
        for i in (0..n).rev() {
            if nums[i] < k {
                return true;
            }
            while let Some(&top) = stack.last() {
                if nums[i] > top {
                    k = top;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(nums[i]);
        }
        false
    }
}