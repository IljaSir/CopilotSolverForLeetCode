impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let (mut i, mut j, mut sum, mut res) = (0, 0, 0, std::i32::MAX);
        while j < nums.len() {
            sum += nums[j];
            while sum >= target {
                res = res.min((j - i + 1) as i32);
                sum -= nums[i];
                i += 1;
            }
            j += 1;
        }
        if res == std::i32::MAX { 0 } else { res }
    }
}