impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut count = 0;
        let mut index = 0;
        let mut i = 0;
        let mut j = 1;
        let mut k = 2;
        let len = nums.len();
        while index < len {
            if j >= len || k >= len {
                index += 1;
                i = index;
                j = index + 1;
                k = index + 2;
            }
            if nums[j] - nums[i] == diff && nums[k] - nums[j] == diff {
                count += 1;
            }
            j += 1;
            k += 1;
        }
        count
    }
}