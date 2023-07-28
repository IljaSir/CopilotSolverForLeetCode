impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            let n = j - i;
            if n >= 2 {
                if n >= 4 {
                    return true;
                }
                if j < nums.len() && nums[j] == nums[i] + 1 {
                    i = j + 1;
                    while i < nums.len() && nums[i] == nums[i - 1] + 1 {
                        i += 1;
                    }
                    if i - j == 2 {
                        return true;
                    }
                } else {
                    i = j;
                }
            } else {
                i = j;
            }
        }
        false
    }
}