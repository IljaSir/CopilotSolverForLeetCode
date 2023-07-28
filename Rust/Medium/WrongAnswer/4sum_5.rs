impl Solution {
    pub fn four_sum(nums: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut sum = Vec::new();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() {
                let mut k = j + 1;
                while k < nums.len() {
                    let mut l = k + 1;
                    while l < nums.len() {
                        if nums[i] + nums[j] + nums[k] + nums[l] == target {
                            sum.push(vec![nums[i], nums[j], nums[k], nums[l]]);
                        }
                        l += 1;
                    }
                    k += 1;
                }
                j += 1;
            }
            i += 1;
        }
        sum
    }
}