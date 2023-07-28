impl Solution {
    pub fn is_possible_divide(nums: Vec<i32>, k: i32) -> bool {
        
        let k = k as usize;
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[j - 1] + 1 {
                j += 1;
            }
            if j - i < k {
                return false;
            }
            let mut m = j - i;
            while m >= k {
                nums.drain(i..i + k);
                m -= k;
            }
            i += m;
        }
        nums.len() == 0
    }
}