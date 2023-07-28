impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let mut stack = Vec::new();
        let mut min = std::i32::MAX;
        for &num in nums.iter().rev() {
            if num < min {
                min = num;
            } else if num > min {
                while let Some(&top) = stack.last() {
                    if top < num {
                        return true;
                    }
                    stack.pop();
                }
                stack.push(num);
            }
        }
        false
    }
}