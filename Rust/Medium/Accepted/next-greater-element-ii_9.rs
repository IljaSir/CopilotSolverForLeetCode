impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut res = vec![-1; nums.len()];
        let mut stack: Vec<usize> = vec![];
        for i in 0..nums.len() * 2 {
            let cur = nums[i % nums.len()];
            while let Some(&top) = stack.last() {
                if nums[top] < cur {
                    res[top] = cur;
                    stack.pop();
                } else {
                    break;
                }
            }
            if i < nums.len() {
                stack.push(i);
            }
        }
        res
    }
}