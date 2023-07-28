impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        

        let mut ans = Vec::new();
        let mut nums = nums;
        for i in 0..nums.len() {
            let idx = (nums[i].abs() - 1) as usize;
            if nums[idx] < 0 {
                ans.push(idx as i32 + 1);
            }
            nums[idx] *= -1;
        }
        ans
    }
}