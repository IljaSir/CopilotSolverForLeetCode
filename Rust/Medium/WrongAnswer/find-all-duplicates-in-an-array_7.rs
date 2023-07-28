impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        

        let mut nums = nums;
        let mut result = vec![];
        let mut i = 0;
        while i < nums.len() {
            if nums[i] != (i + 1) as i32 {
                let j = nums[i] as usize - 1;
                if nums[i] == nums[j] {
                    result.push(nums[i]);
                    i += 1;
                } else {
                    nums.swap(i, j);
                }
            } else {
                i += 1;
            }
        }
        result
    }
}