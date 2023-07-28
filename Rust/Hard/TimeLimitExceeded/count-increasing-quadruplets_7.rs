impl Solution {
    pub fn count_quadruplets(nums: Vec<i32>) -> i64 {
        
        let mut res = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                for k in j+1..nums.len() {
                    for l in k+1..nums.len() {
                        if nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l] {
                            res += 1;
                        }
                    }
                }
            }
        }
        res as i64
    }
}