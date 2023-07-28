impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut stack = vec![];
        let mut res = vec![-1; nums.len()];
        for (i, &num) in nums.iter().enumerate() {
            while let Some(&top) = stack.last() {
                if top > num {
                    res[i] = top;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(num);
        }
        res
    }
}