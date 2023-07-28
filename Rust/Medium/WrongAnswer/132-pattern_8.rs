impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        

        let mut min = std::i32::MAX;
        let mut stack = vec![];
        for &num in nums.iter().rev() {
            if num > min {
                while let Some(&top) = stack.last() {
                    if top < num {
                        break;
                    }
                    stack.pop();
                }
                if let Some(&top) = stack.last() {
                    if top > num {
                        return true;
                    }
                }
            }
            min = min.min(num);
            stack.push(num);
        }
        false
    }
}