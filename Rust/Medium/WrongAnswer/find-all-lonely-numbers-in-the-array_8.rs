impl Solution {
    pub fn find_lonely(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = vec![];
        for (i, num) in nums.iter().enumerate() {
            if i == 0 {
                if *num != nums[i + 1] {
                    res.push(*num);
                }
            } else if i == nums.len() - 1 {
                if *num != nums[i - 1] {
                    res.push(*num);
                }
            } else if *num != nums[i - 1] && *num != nums[i + 1] {
                res.push(*num);
            }
        }
        res
    }
}