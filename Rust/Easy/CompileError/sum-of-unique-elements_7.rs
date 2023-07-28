impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut count = vec![0; 101];
        for x in nums {
            count[x as usize] += 1;
        }
        for i in 0..count.len() {
            if count[i] == 1 {
                sum += i;
            }
        }
        sum
    }
}