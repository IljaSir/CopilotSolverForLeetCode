impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut cnt = 0;
        let mut nums = nums;
        nums.sort();
        for i in 0..nums.len() {
            cnt += 1;
            let mut j = i + 1;
            while j < nums.len() && nums[j] - nums[i] < k {
                j += 1;
            }
            if j < nums.len() && nums[j] - nums[i] == k {
                cnt += 1;
            }
        }
        cnt
    }
}