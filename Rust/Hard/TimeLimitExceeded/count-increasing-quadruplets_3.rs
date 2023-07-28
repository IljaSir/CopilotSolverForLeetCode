impl Solution {
    pub fn count_quadruplets(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        for i in 0..nums.len()-3 {
            for j in i+1..nums.len()-2 {
                for k in j+1..nums.len()-1 {
                    for l in k+1..nums.len() {
                        if nums[i] < nums[k] && nums[k] < nums[j] && nums[j] < nums[l] {
                            count += 1;
                        }
                    }
                }
            }
        }
        count as i64
    }
}