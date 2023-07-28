impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let mut stack = Vec::new();
        let mut result = vec![-1; nums.len()];
        for i in 0..nums.len() * 2 {
            let j = i % nums.len();
            while let Some(&top) = stack.last() {
                if nums[top] < nums[j] {
                    stack.pop();
         esult
    }
}