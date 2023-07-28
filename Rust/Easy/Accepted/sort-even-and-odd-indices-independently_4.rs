impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut odds = nums.iter().enumerate().filter(|(i, _)| i % 2 == 1).map(|(_, &v)| v).collect::<Vec<i32>>();
        let mut evens = nums.iter().enumerate().filter(|(i, _)| i % 2 == 0).map(|(_, &v)| v).collect::<Vec<i32>>();
        odds.sort();
        odds.reverse();
        evens.sort();
        let mut result = Vec::new();
        for i in 0..nums.len() {
            if i % 2 == 0 {
                result.push(evens[i / 2]);
            } else {
                result.push(odds[i / 2]);
            }
        }
        result
    }
}