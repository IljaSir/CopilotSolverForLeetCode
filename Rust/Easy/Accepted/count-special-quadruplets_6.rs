impl Solution {
    pub fn count_quadruplets(nums: Vec<i32>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                for k in j+1..nums.len() {
                    for l in k+1..nums.len() {
                        if nums[i] + nums[j] + nums[k] == nums[l] {
                            cnt += 1;
                        }
                    }
                }
            }
        }
        cnt
    }
}