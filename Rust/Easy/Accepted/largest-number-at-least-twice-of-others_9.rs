impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max_index = -1;
        let mut second_max = -1;
        for (i, n) in nums.iter().enumerate() {
            if *n > max {
                second_max = max;
                max = *n;
                max_index = i as i32;
            } else if *n > second_max {
                second_max = *n;
            }
        }
        if max >= 2 * second_max {
            max_index
        } else {
            -1
        }
    }
}