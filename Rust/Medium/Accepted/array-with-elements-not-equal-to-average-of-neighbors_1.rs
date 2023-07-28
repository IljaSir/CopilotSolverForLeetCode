impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut res = vec![];
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            res.push(nums[i]);
            res.push(nums[j]);
            i += 1;
            j -= 1;
        }
        if i == j {
            res.push(nums[i]);
        }
        res
    }
}