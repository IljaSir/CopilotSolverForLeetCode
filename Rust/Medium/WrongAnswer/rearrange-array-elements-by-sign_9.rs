impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_unstable_by_key(|&x| x.abs());
        let mut result: Vec<i32> = vec![];
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            result.push(nums[j]);
            result.push(nums[i]);
            i += 1;
            j -= 1;
        }
        if i == j {
            result.push(nums[i]);
        }
        result
    }
}