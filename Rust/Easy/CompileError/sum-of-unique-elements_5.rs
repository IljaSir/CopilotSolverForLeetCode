impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut count = [0; 101];
        for num in nums.iter() {
            count[*num as usize] += 1;
        }
        let mut sum = 0;
        for (i, num) in count.iter().enumerate() {
            if *num == 1 {
                sum += i;
            }
        }
        sum
    }
}