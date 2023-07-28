impl Solution {
    pub fn find_smallest_integer(nums: Vec<i32>, value: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        let mut i = 0;
        let mut j = nums.len();
        let mut k = 0;
        while i < j {
            k = (i + j) / 2;
            if nums[k] > count {
                j = k;
            } else {
                i = k + 1;
                count += value;
            }
        }
        count as i32
    }
}