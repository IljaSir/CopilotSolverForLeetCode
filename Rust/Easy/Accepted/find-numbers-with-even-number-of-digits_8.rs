impl Solution {
    pub fn find_numbers(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for n in nums {
            let mut tmp = 0;
            let mut m = n;
            while m > 0 {
                m /= 10;
                tmp += 1;
            }
            if tmp % 2 == 0 {
                res += 1;
            }
        }
        res
    }
}