impl Solution {
    pub fn find_numbers(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for n in nums {
            if n.to_string().len() % 2 == 0 {
                count += 1;
            }
        }
        count
    }
}