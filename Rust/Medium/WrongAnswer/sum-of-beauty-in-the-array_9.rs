impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut max = vec![0; nums.len()];
        let mut min = vec![0; nums.len()];
        let mut mn = std::i32::MAX;
        let mut mx = std::i32::MIN;
        for i in 0..nums.len() {
            mn = mn.min(nums[i]);
            mx = mx.max(nums[i]);
            min[i] = mn;
            max[i] = mx;
        }
        for i in 1..nums.len() - 1 {
            if nums[i] > min[i - 1] && nums[i] < max[i + 1] {
                res += 2;
            } else if nums[i - 1] < nums[i] && nums[i] < nums[i + 1] {
                res += 1;
            }
        }
        res
    }
}