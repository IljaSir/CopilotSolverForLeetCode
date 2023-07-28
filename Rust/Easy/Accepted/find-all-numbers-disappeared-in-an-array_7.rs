impl Solution {
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] != (i + 1) as i32 {
                let pos = nums[i] as usize - 1;
                if nums[i] != nums[pos] {
                    nums.swap(i, pos);
                    continue;
                }
            }
            i += 1;
        }
        let mut res = Vec::new();
        for i in 0..nums.len() {
            if nums[i] != (i + 1) as i32 {
                res.push((i + 1) as i32);
            }
        }
        res
    }
}