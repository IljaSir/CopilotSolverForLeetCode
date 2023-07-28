impl Solution {
    pub fn average_value(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        for i in nums {
            if i % 2 == 0 && i % 3 == 0 {
                sum += i;
                count += 1;
            }
        }
        if count == 0 {
            return 0;
        }
        return sum / count;
    }
}