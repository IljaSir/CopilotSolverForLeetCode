impl Solution {
    pub fn count_quadruplets(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..nums.len()-3 {
            for j in i+1..nums.len()-2 {
                for k in j+1..nums.len()-1 {
                    for l in k+1..nums.len() {
                        if nums[i] + nums[j] + nums[k] == nums[l] {
                            res += 1;
                        }
                    }
                }
            }
        }
        res
    }
}