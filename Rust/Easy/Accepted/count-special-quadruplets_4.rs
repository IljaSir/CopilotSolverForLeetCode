impl Solution {
    pub fn count_quadruplets(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for a in 0..nums.len()-3 {
            for b in a+1..nums.len()-2 {
                for c in b+1..nums.len()-1 {
                    for d in c+1..nums.len() {
                        if nums[a] + nums[b] + nums[c] == nums[d] {
                            res += 1;
                        }
                    }
                }
            }
        }
        res
    }
}