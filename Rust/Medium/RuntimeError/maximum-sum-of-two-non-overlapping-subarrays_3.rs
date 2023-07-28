impl Solution {
    pub fn max_sum_two_no_overlap(nums: Vec<i32>, first_len: i32, second_len: i32) -> i32 {
        
        let first_len = first_len as usize;
        let second_len = second_len as usize;
        let mut first = vec![0; nums.len()];
        let mut second = vec![0; nums.len()];
        let mut sum = 0;
        for (i, &num) in nums.iter().enumerate() {
            if i < first_len {
                sum += num;
                first[i] = sum;
            } else {
                sum += num;
                sum -= nums[i - first_len];
                first[i] = first[i - 1].max(sum);
            }
        }
        sum = 0;
        for (i, &num) in nums.iter().enumerate().rev() {
            if i >= nums.len() - second_len {
                sum += num;
                second[i] = sum;
            } else {
                sum += num;
                sum -= nums[i + second_len];
                second[i] = second[i + 1].max(sum);
            }
        }
        second
            .iter()
            .enumerate()
            .skip(first_len - 1)
            .take(nums.len() - first_len - second_len + 1)
            .map(|(i, &second)| first[i - first_len] + second)
            .max()
            .unwrap()
    }
}