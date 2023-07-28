impl Solution {
    pub fn max_score_indices(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ones = 0;
        for n in &nums {
            if *n == 1 {
                ones += 1;
            }
        }
        let mut zeros = 0;
        let mut max = 0;
        let mut result = vec![];
        for i in 0..nums.len() {
            if nums[i] == 0 {
                zeros += 1;
            } else {
                ones -= 1;
            }
            let score = zeros + ones;
            if score > max {
                max = score;
                result = vec![i as i32 + 1];
            } else if score == max {
                result.push(i as i32 + 1);
            }
        }
        result
    }
}