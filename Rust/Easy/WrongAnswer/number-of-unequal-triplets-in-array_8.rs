impl Solution {
    pub fn unequal_triplets(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        for i in 0..nums.len() - 2 {
            if nums[i] == nums[i + 1] || nums[i] == nums[i + 2] {
                continue;
            }
            for j in i + 1..nums.len() - 1 {
                if nums[j] == nums[j + 1] {
                    continue;
                }
                for k in j + 1..nums.len() {
                    if nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k] {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}