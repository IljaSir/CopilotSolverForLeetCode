impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut counts = vec![0; 101];
        for &num in nums.iter() {
            counts[num as usize] += 1;
        }
        let mut sum = 0;
        for (num, &count) in counts.iter().enumerate() {
            if count == 1 {
                sum += num;
            }
        }
        sum as i32
    }
}