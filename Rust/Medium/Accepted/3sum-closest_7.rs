impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut nums = nums;
        let mut ret = 0;
        let mut diff = i32::max_value();
        nums.sort();
        for i in 0..nums.len() - 2 {
            let mut j = i + 1;
            let mut k = nums.len() - 1;
            while j < k {
                let sum = nums[i] + nums[j] + nums[k];
                if sum == target {
                    return sum;
                }
                if (sum - target).abs() < diff {
                    diff = (sum - target).abs();
                    ret = sum;
                }
                if sum > target {
                    k -= 1;
                } else {
                    j += 1;
                }
            }
        }
        ret
    }
}