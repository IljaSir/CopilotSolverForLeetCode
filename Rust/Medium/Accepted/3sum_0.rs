impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut result = Vec::new();
        for i in 0..nums.len() {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }
            let mut lo = i + 1;
            let mut hi = nums.len() - 1;
            while lo < hi {
                let sum = nums[i] + nums[lo] + nums[hi];
                if sum < 0 {
                    lo += 1;
                } else if sum > 0 {
                    hi -= 1;
                } else {
                    result.push(vec![nums[i], nums[lo], nums[hi]]);
                    lo += 1;
                    hi -= 1;
                    while lo < hi && nums[lo] == nums[lo - 1] {
                        lo += 1;
                    }
                    while lo < hi && nums[hi] == nums[hi + 1] {
                        hi -= 1;
                    }
                }
            }
        }
        result
    }
}