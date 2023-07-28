impl Solution {
    pub fn second_greater_element(nums: Vec<i32>) -> Vec<i32> {
        
        let mut stk = Vec::new();
        let mut ans = vec![-1; nums.len()];
        let mut max = -1;
        for i in 0..nums.len() {
            while let Some(&top) = stk.last() {
                if nums[top] < nums[i] {
                    ans[top] = nums[i];
                    stk.pop();
                } else {
                    break;
                }
            }
            if nums[i] > max {
                max = nums[i];
            } else {
                stk.push(i);
            }
        }
        ans
    }
}