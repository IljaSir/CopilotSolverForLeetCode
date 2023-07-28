impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut sum: i32 = 0;
        for i in &nums {
            sum += i;
        }
        let mut res: Vec<i32> = Vec::new();
        let mut tmp: i32 = 0;
        for i in (0..nums.len()).rev() {
            tmp += nums[i];
            sum -= nums[i];
            res.push(nums[i]);
            if tmp > sum {
                return res;
            }
        }
        res
    }
}