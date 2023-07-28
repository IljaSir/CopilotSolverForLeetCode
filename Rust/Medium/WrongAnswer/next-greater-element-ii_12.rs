impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut stack: Vec<i32> = vec![];
        let mut res: Vec<i32> = vec![];
        for _ in 0..2 {
            for num in nums.iter().rev() {
                while !stack.is_empty() && *stack.last().unwrap() <= *num {
                    stack.pop();
                }
                if stack.is_empty() {
                    res.push(-1);
                } else {
                    res.push(*stack.last().unwrap());
                }
                stack.push(*num);
            }
        }
        res.reverse();
        res
    }
}