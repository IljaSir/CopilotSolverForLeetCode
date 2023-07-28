impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut result = vec![];
        let k = k as usize;
        for i in 0..nums.len() {
            let mut sum = 0;
            let mut count = 0;
            for j in (0..k).rev() {
                if i >= j {
                    sum += nums[i - j];
                    count += 1;
                } else {
                    break;
                }
            }
            for j in 0..k {
                if i + j < nums.len() {
                    sum += nums[i + j];
                    count += 1;
                } else {
                    break;
                }
            }
            if count > 1 {
                result.push(sum / count as i32);
            } else {
                result.push(-1);
            }
        }
        result
    }
}