impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ones = 0;
        let mut zeros = 0;
        let mut max = 0;
        let mut result = vec![];
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zeros += 1;
            } else {
                ones += 1;
            }
        }
        let mut cur = 0;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zeros -= 1;
                cur += 1;
            } else {
                ones -= 1;
                cur -= 1;
            }
            if cur > max {
                max = cur;
                result.clear();
                result.push(i as i32 + 1);
            } else if cur == max {
                result.push(i as i32 + 1);
            }
        }
        result
    }
}