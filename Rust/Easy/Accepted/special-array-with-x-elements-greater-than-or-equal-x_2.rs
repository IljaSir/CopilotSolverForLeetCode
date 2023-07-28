impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        for i in 1..=100 {
            let mut count = 0;
            for &n in &nums {
                if n >= i {
                    count += 1;
                }
            }
            if count == i {
                return i;
            }
        }
        -1
    }
}