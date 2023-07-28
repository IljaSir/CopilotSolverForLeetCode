impl Solution {
    pub fn good_indices(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let k = k as usize;
        let mut res = Vec::new();
        let mut max = nums[0..k].iter().max().unwrap();
        let mut min = nums[nums.len()-k..].iter().min().unwrap();
        for i in k..(nums.len()-k) {
            if nums[i] >= *max && nums[i] <= *min {
                res.push(i as i32);
            }
            if nums[i] > *max {
                max = &nums[i];
            }
            if nums[i+k] < *min {
                min = &nums[i+k];
            }
        }
        res
    }
}