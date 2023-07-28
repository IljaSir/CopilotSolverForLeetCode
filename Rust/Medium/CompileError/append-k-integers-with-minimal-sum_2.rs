impl Solution {
    pub fn minimal_k_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        let mut k = k;
        let mut sum = 0;
        nums.sort();
        for i in 0..nums.len()-1 {
            let diff = nums[i+1] - nums[i] - 1;
            if diff > 0 {
                if k > diff {
                    sum += (nums[i] + 1 + nums[i] + diff) * diff / 2;
                    k -= diff;
                } else {
                    sum += (nums[i] + 1 + nums[i] + k) * k / 2;
                    k = 0;
                    break;
                }
            }
        }
        if k > 0 {
            sum += (nums[nums.len()-1] + k) * k / 2;
        }
        sum
    }
}