impl Solution {
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            let j = (nums[i] - 1) as usize;
            if nums[i] != nums[j] {
                nums.swap(i, j);
            } else {
                i += 1;
            }
        }
        nums.iter()
            .enumerate()
            .filter(|(i, &x)| x != (*i + 1) as i32)
            .map(|(_, &x)| x)
            .collect()
    }
}