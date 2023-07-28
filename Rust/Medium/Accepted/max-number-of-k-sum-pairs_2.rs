impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut ans = 0;
        while i < j {
            let sum = nums[i] + nums[j];
            if sum == k {
                ans += 1;
                i += 1;
                j -= 1;
            } else if sum < k {
                i += 1;
            } else {
                j -= 1;
            }
        }
        ans
    }
}