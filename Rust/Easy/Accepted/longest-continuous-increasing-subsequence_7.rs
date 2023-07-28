impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        let mut max_len = 0;
        let mut cur_len = 0;
        let mut prev = std::i32::MIN;
        for i in 0..nums.len() {
            if nums[i] > prev {
                cur_len += 1;
                max_len = max_len.max(cur_len);
            } else {
                cur_len = 1;
            }
            prev = nums[i];
        }
        max_len as i32
    }
}