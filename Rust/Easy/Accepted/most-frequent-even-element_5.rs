impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut counts = vec![0; 100001];
        for n in nums {
            if n % 2 == 0 {
                counts[n as usize] += 1;
            }
        }
        let mut max = 0;
        let mut max_index = -1;
        for i in 0..counts.len() {
            if counts[i] > max {
                max = counts[i];
                max_index = i as i32;
            }
        }
        max_index
    }
}