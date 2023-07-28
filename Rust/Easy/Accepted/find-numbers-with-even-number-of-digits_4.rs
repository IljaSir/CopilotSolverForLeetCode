impl Solution {
    pub fn find_numbers(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for num in nums {
            let mut n = num;
            let mut digits = 0;
            while n > 0 {
                n /= 10;
                digits += 1;
            }
            if digits % 2 == 0 {
                count += 1;
            }
        }
        count
    }
}