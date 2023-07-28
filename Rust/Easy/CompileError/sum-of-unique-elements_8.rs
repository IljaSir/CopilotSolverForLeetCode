impl Solution {
    pub fn sum_of_unique(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut hash = [0; 101];
        for n in nums {
            hash[n as usize] += 1;
        }
        for (i, n) in hash.iter().enumerate() {
            if *n == 1 {
                sum += i;
            }
        }
        sum
    }
}