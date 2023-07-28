impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut res = nums[0] + nums[1] + nums[2];
        let mut min = (res - target).abs();
        for i in 0..nums.len() - 2 {
            let mut j = i + 1;
            let mut k = nums.len() - 1;
            while j < k {
                let sum = nums[i] + nums[j] + nums[k];
                if (sum - target).abs() < min {
                    res = sum;
                    min = (sum - target).abs();
                }
                if sum > target {
                    k -= 1;
                } else if sum < target {
                    j += 1;
                } else {
                    return sum;
                }
            }
        }
        res
    }
}