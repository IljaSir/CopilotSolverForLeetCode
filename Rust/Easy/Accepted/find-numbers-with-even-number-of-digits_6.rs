impl Solution {
    pub fn find_numbers(nums: Vec<i32>) -> i32 {
        
        let mut result = 0;
        for i in nums {
            let mut count = 0;
            let mut num = i;
            while num > 0 {
                num = num / 10;
                count += 1;
            }
            if count % 2 == 0 {
                result += 1;
            }
        }
        result
    }
}