impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut max = std::i32::MIN;
        let mut min = std::i32::MAX;
        let mut ans = std::i32::MIN;
        for i in nums {
            let temp = max;
            max = std::cmp::max(std::cmp::max(max * i, min * i), i);
            min = std::cmp::min(std::cmp::min(temp * i, min * i), i);
            ans = std::cmp::max(ans, max);
        }
        ans
    }
}