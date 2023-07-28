impl Solution {
    pub fn next_greater_elements(nums: Vec<i32>) -> Vec<i32> {
        

        let n = nums.len();
        let mut res = vec![-1; n];
        let mut stack = Vec::new();
        for i in 0..n * 2 {
            while let Some(&j) = stack.last() {
                if nums[i % n] > nums[j] {
                    res[j] = nums[i % n];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i % n);
        }
        res
    }
}