impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == 0 {
                i += 1;
                continue;
            }
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            ans += j - i;
            i = j;
        }
        ans
    }
}