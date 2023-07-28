impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut res = Vec::new();
        for (i, &j) in l.iter().enumerate() {
            let mut nums = nums[j as usize..=r[i] as usize].to_vec();
            nums.sort();
            let diff = nums[1] - nums[0];
            let mut flag = true;
            for i in 1..nums.len() {
                if nums[i] - nums[i - 1] != diff {
                    flag = false;
                    break;
                }
            }
            res.push(flag);
        }
        res
    }
}