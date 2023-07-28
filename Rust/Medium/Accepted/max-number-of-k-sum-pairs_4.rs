impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut ret = 0;
        while i < j {
            let sum = nums[i] + nums[j];
            if sum == k {
                ret += 1;
                i += 1;
                j -= 1;
            } else if sum > k {
                j -= 1;
            } else {
                i += 1;
            }
        }
        ret
    }
}