impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut counts = [0; 100001];
        for &num in nums.iter() {
            counts[num as usize] += 1;
        }
        let mut max = 0;
        let mut result = -1;
        for i in 0..100001 {
            if i % 2 == 0 && counts[i] > max {
                max = counts[i];
                result = i as i32;
            }
        }
        result
    }
}