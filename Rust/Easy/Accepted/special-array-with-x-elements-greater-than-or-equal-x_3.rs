impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 1001];
        for i in nums {
            count[i as usize] += 1;
        }
        let mut sum = 0;
        for i in (0..=1000).rev() {
            sum += count[i];
            if sum == i {
                return i as i32;
            }
        }
        -1
    }
}