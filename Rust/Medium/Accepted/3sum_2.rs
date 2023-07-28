impl Solution {
    pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        let n = nums.len();
        for i in 0..n {
            if i > 0 && nums[i] == nums[i - 1] {
                continue;
            }
            let mut j = i + 1;
            let mut k = n - 1;
            while j < k {
                if nums[i] + nums[j] + nums[k] == 0 {
                    res.push(vec![nums[i], nums[j], nums[k]]);
                    j += 1;
                    k -= 1;
                    while j < k && nums[j] == nums[j - 1] {
                        j += 1;
                    }
                    while j < k && nums[k] == nums[k + 1] {
                        k -= 1;
                    }
                } else if nums[i] + nums[j] + nums[k] < 0 {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
        }
        res
    }
}