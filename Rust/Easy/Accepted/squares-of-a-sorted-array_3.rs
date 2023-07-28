impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = vec![];
        for num in nums {
            result.push(num * num);
        }
        result.sort();
        result
    }
}