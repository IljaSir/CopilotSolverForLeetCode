impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut count = vec![0; 101];
        for num in nums.into_iter() {
            count[num as usize] += 1;
        }
        for (i, c) in count.into_iter().enumerate() {
            if c == 1 {
                sum += i as i32;
            }
        }
        sum
    }
}