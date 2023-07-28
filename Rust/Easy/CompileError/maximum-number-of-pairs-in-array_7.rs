impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut pairs = 0;
        let mut left = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            if j - i > 1 {
                pairs += (j - i) / 2;
                left += (j - i) % 2;
            } else {
                left += 1;
            }
            i = j;
        }
        vec![pairs, left]
    }
}