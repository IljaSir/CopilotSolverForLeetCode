impl Solution {
    pub fn find_numbers(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in nums {
            let mut tmp = i;
            let mut len = 0;
            while tmp > 0 {
                tmp /= 10;
                len += 1;
            }
            if len % 2 == 0 {
                count += 1;
            }
        }
        count
    }
}