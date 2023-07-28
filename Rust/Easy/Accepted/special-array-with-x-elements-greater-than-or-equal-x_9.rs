impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        let mut sorted = nums;
        sorted.sort();
        for x in 1..=1000 {
            let mut count = 0;
            for &num in &sorted {
                if num >= x {
                    count += 1;
                }
            }
            if count == x {
                return x;
            }
        }
        -1
    }
}