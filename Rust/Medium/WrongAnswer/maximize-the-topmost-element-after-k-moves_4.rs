impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        let mut i = 0;
        while i < nums.len() && nums[i] == 0 {
            i += 1;
        }
        let mut j = i;
        while j < nums.len() && count < k {
            if j + 1 < nums.len() && nums[j] == nums[j + 1] {
                j += 1;
            } else {
                let n = (j - i + 1) as i32;
                if count + n > k {
                    break;
                }
                count += n;
                i = j + 1;
                j = i;
            }
        }
        if count < k {
            nums[i - 1]
        } else {
            nums[j]
        }
    }
}