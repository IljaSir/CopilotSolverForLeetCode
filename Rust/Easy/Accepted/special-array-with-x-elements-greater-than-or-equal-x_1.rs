impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        for i in 1..=nums.len() {
            let mut count = 0;
            for j in nums.iter() {
                if *j >= i as i32 {
                    count += 1;
                }
            }
            if count == i {
                return i as i32;
            }
        }
        -1
    }
}