impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut largest = 0;
        let mut largest_index = -1;
        for (i, num) in nums.iter().enumerate() {
            if *num > largest {
                largest = *num;
                largest_index = i as i32;
            }
        }
        for num in nums.iter() {
            if *num == largest {
                continue;
            }
            if *num * 2 > largest {
                return -1;
            }
        }
        largest_index
    }
}