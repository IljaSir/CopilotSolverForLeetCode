impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_index = 0;
        let mut second_max = 0;
        for (i, v) in nums.iter().enumerate() {
            if *v > max {
                second_max = max;
                max = *v;
                max_index = i;
            } else if *v > second_max {
                second_max = *v;
            }
        }
        if max >= 2 * second_max {
            max_index as i32
        } else {
            -1
        }
    }
}