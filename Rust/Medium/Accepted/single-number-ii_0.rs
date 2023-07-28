impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        

        let mut one = 0;
        let mut two = 0;
        for i in nums {
            one = (one ^ i) & !two;
            two = (two ^ i) & !one;
        }
        one
    }
}