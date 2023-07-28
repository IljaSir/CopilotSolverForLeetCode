impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        

        let mut sorted = nums.clone();
        sorted.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < nums.len() && nums[i] == sorted[i] {
            i += 1;
        }
        while j > i && nums[j] == sorted[j] {
            j -= 1;
        }
        (j - i + 1) as i32
    }
}