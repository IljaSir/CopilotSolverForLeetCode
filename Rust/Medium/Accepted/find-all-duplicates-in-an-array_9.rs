impl Solution {
    pub fn find_duplicates(nums: Vec<i32>) -> Vec<i32> {
        

        let mut ret = Vec::new();
        let mut nums = nums;
        for i in 0..nums.len() {
            let val = nums[i].abs();
            let index = val as usize - 1;
            if nums[index] < 0 {
                ret.push(val);
            } else {
                nums[index] *= -1;
            }
        }
        ret
    }
}